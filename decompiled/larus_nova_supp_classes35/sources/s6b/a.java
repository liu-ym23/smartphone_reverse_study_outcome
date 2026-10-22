package s6b;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class a {
    public final Map<Class<b<?, ?>>, b<?, ?>> a;

    /* JADX INFO: renamed from: s6b.a$a, reason: collision with other inner class name */
    public static final class C0299a {
    }

    static {
    }

    public a() {
        this.a = new LinkedHashMap();
    }

    public final void a(b<?, ?> r4) {
        Intrinsics.checkNotNullParameter(r4, "spec");
        if (this.a.containsKey(r4.getClass()) == true) goto L6;
        Map<Class<b<?, ?>>, b<?, ?>> r0 = this.a;
        Class<?> r1 = r4.getClass();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type java.lang.Class<com.ss.android.lark.chat.spec.IFeatureSpec<*, *>>");
        r0.put((Class<b<?, ?>>) r1, r4);
        return;
    }

    public final <Patch extends Spec, Spec extends b<Spec, Patch>> Spec b(Class<Spec> r2) {
        Intrinsics.checkNotNullParameter(r2, "clz");
        Object r3 = ((LinkedHashMap) this.a).get(r2);
        if ((r3 instanceof b) == true) goto L7;
        return null;
    L7:
        return (Spec) r3;
    }
}
