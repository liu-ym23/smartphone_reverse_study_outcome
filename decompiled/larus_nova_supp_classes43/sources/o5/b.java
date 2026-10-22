package o5;

import com.bytedance.ai.resource.IAIPackageNetService;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new a());
    }

    public static IAIPackageNetService a() {
        return (IAIPackageNetService) a.getValue();
    }
}
