package or1;

import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p<T, R> implements Function {
    public static final p a = null;

    static {
        a = new p();
    }

    public p() {
    }

    public final Object apply(Object r3) {
        BaseResponse r4 = (BaseResponse) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        return new Pair(r4.data, Boolean.valueOf(r4.extra.isAnonymousIsSilence()));
    }
}
