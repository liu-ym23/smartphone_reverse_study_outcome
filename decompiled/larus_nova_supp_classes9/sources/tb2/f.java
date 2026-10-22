package tb2;

import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.o;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.x;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(e r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        x r0 = r.b;
        Intrinsics.checkNotNullParameter(vb2.b.class, "clazz");
        o r1 = r.f;
        r1.getClass();
        vb2.a r3 = (vb2.a) ((HashMap) r1.a).get(vb2.b.class);     // Catch: ClassCastException -> L5
    L7:
        vb2.b r4 = (vb2.b) r3;
        if (r4 != null) goto L10;
    L12:
        return false;
    L10:
        if (r2.a().a() == null) goto L12;
        return r4.a(r2.a().a());
    L5:
        e = move-exception;
        SafetyGuard.a(null, e, null);
        r3 = null;
        goto L7
    }
}
