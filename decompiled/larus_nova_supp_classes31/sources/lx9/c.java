package lx9;

import com.larus.suggest.impl.wcb.model.WcbSurface;
import com.larus.suggest.impl.wcb.policy.z;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public final WcbSurface a;
    public final AtomicReference<z> b;

    public c(WcbSurface r2) {
        Intrinsics.checkNotNullParameter(r2, "surface");
        this.a = r2;
        this.b = new AtomicReference(null);
    }
}
