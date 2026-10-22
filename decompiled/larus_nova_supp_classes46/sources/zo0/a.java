package zo0;

import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final HashMap<String, b> a = null;

    static {
        a = new HashMap();
    }

    @JvmStatic
    public static final b a(PerformanceScene r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        HashMap<String, b> r0 = a;
        b r1 = r0.get(r2.getValue());
        if (r1 == null) goto L5;
        return r1;
    L5:
        b r3 = new b(r2);
        r0.put(r2.getValue(), r3);
        return r3;
    }
}
