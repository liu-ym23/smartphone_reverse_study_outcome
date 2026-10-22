package or1;

import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r<T, R> implements Function {
    public static final r a = null;

    static {
        a = new r();
    }

    public r() {
    }

    public final Object apply(Object r2) {
        FollowPair r3 = (FollowPair) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3;
    }
}
