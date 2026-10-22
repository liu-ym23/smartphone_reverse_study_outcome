package vv1;

import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import io.reactivex.functions.BiFunction;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T1, T2, R> implements BiFunction {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final Object apply(Object r1, Object r2) {
        FeedDataKey r3 = (FeedDataKey) r1;
        List r4 = (List) r2;
        Intrinsics.checkNotNull(r4);
        return r4;
    }
}
