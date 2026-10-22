package bp1;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T, R> implements Function {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((Throwable) r2, "it");
        int r3 = a.h;
        ALogger.e("ExtShareEnhancePanel", "ShopGuideID Error: use default data");
        return new i(0);
    }
}
