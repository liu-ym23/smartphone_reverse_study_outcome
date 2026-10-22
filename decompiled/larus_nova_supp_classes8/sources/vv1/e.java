package vv1;

import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e<T, R> implements Function {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final Object apply(Object r2) {
        FeedDataKey r3 = (FeedDataKey) r2;
        Intrinsics.checkNotNullParameter(r3, "obj");
        return Integer.valueOf(r3.hashCode());
    }
}
