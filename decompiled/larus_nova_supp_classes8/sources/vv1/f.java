package vv1;

import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import io.reactivex.functions.BiFunction;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f<T1, T2, R> implements BiFunction {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final Object apply(Object r1, Object r2) {
        FeedDataKey r3 = (FeedDataKey) r1;
        List r4 = (List) r2;
        Intrinsics.checkNotNull(r4);
        return r4;
    }
}
