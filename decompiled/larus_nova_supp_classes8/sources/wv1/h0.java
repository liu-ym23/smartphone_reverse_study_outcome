package wv1;

import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class h0 implements Function {
    public /* synthetic */ h0() {
    }

    public final Object apply(Object r1) {
        return Integer.valueOf(((FeedDataKey) r1).hashCode());
    }
}
