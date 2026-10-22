package uw1;

import com.bytedance.android.livesdk.feed.IFeedActionCallback;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.h;
import com.bytedance.android.livesdkapi.feed.constant.FeedStyle;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e {
    public final FeedStyle a;
    public final h b;
    public final FeedDataKey c;
    public final PublishSubject<Boolean> d;
    public final IFeedActionCallback e;

    public final Map<Integer, b90.a> a() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(2131566259, new d(this)), TuplesKt.to(2131565987, new c(this))});
    }

    public e(FeedStyle r2, h r3, FeedDataKey r4, PublishSubject<Boolean> r5, IFeedActionCallback r6) {
        Intrinsics.checkNotNullParameter(r2, "feedStyle");
        Intrinsics.checkNotNullParameter(r3, "feedLiveParams");
        Intrinsics.checkNotNullParameter(r4, "feedDataKey");
        Intrinsics.checkNotNullParameter(r5, "userVisibility");
        Intrinsics.checkNotNullParameter(r6, "feedActionCallback");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
