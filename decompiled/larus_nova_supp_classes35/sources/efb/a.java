package efb;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.feed.shared.page.FeedRecyclerView;
import com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter;
import com.ss.android.lark.feed.shared.page.adapter.LarkFeedInBoxListAdapter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final FeedListAdapter a;
    public final RecyclerView b;
    public final List<Integer> c;

    public a(LarkFeedInBoxListAdapter r2, FeedRecyclerView r3) {
        this.c = new ArrayList();
        this.a = r2;
        this.b = r3;
    }
}
