package z91;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T, R> implements Function {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final Object apply(Object r2) {
        BaseResponse r3 = (BaseResponse) r2;
        Intrinsics.checkNotNullParameter(r3, "response");
        Object r4 = r3.data;
        if (r4 == null) goto L7;
        return (IBaseUser) r4;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.user.IBaseUser");
    }
}
