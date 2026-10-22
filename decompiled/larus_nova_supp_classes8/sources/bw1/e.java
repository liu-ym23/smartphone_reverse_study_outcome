package bw1;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.TabListModel;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class e {
    public final List<String> a;
    public final LinkedList<FeedItem> b;
    public FeedExtra c;
    public int d;
    public int e;
    public final com.bytedance.android.livesdk.feed.feed.e f;
    public final TabListModel g;

    public abstract String a(int r1);

    public abstract String b();

    public abstract void c();

    public abstract String d();

    public abstract String e(String r1);

    public abstract String f();

    public abstract long g();

    public e(com.bytedance.android.livesdk.feed.feed.e r2, TabListModel r3) {
        Intrinsics.checkNotNullParameter(r2, "itemTab");
        Intrinsics.checkNotNullParameter(r3, "tabListModel");
        this.f = r2;
        this.g = r3;
        this.a = Arrays.asList(new String[]{"homepage_follow", "homepage_follow_ecom", "homepage_ecom_follow"});
        this.b = new LinkedList();
        FeedExtra r4 = new FeedExtra();
        ((Extra) r4).hasMore = true;
        Unit r5 = Unit.INSTANCE;
        this.c = r4;
    }
}
