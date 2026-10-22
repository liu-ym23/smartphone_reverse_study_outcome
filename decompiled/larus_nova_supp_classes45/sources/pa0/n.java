package pa0;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n<T, R> implements Function {
    public static final n a = null;

    static {
        a = new n();
    }

    public n() {
    }

    public final Object apply(Object r3) {
        ExtraResponse r4 = (ExtraResponse) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        return new k((com.bytedance.android.live.recharge.platform.business.model.income.b) r4.data, r4.extra);
    }
}
