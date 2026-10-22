package p12;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.gift.model.a0;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T, R> implements Function {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final Object apply(Object r2) {
        ExtraResponse r3 = (ExtraResponse) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return (a0) r3.data;
    }
}
