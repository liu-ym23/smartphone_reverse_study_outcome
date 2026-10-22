package pz9;

import androidx.fragment.app.Fragment;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements c {
    public static final a a = null;
    public static final HashMap<KClass<? extends zo8.a>, b> b = null;

    public a() {
    }

    static {
        a = new a();
        HashMap<KClass<? extends zo8.a>, b> r0 = new HashMap();
        b = r0;
        f r1 = new f();
        if (r0.containsKey(r1.getType()) == true) goto L5;
        r0.put(r1.getType(), r1);
    L5:
        g r2 = new g();
        if (r0.containsKey(r2.getType()) == true) goto L9;
        r0.put(r2.getType(), r2);
        return;
    }

    @Override // pz9.c
    public final Fragment a(Fragment r3, zo8.a r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "data");
        b r0 = b.get(Reflection.getOrCreateKotlinClass(r4.getClass()));
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r3, r4, r5, r6);
    }
}
