package pa0;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i<T, R> implements Function {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final Object apply(Object r3) {
        ExtraResponse r4 = (ExtraResponse) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        com.bytedance.android.live.recharge.platform.business.model.income.a r0 = (com.bytedance.android.live.recharge.platform.business.model.income.a) r4.data;
        Extra r1 = r4.extra;
        if ((r0 instanceof com.bytedance.android.live.recharge.platform.business.model.income.b) == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L11;
        return r4;
    L11:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        if ((r1 instanceof com.bytedance.android.live.recharge.platform.business.model.income.d) == false) goto L7;
        r2 = true;
        goto L8
    }
}
