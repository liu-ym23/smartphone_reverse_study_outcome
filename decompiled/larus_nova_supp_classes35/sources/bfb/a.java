package bfb;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;
import com.ss.android.lark.feed.shared.data.UpdateRecord;
import com.ss.android.lark.feed.shared.page.FeedRecyclerView;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final RecyclerView a;
    public final HashMap<Long, Integer> b;
    public boolean c;

    /* JADX INFO: renamed from: bfb.a$a, reason: collision with other inner class name */
    public static final class C0013a {
    }

    static {
    }

    public a(FeedRecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "inboxRecyclerView");
        this.a = r2;
        new HashMap();
        FeedFolderCompat r3 = FeedFolderCompat.INSTANCE;
        r3.getUNKNOWN();
        r3.getUNKNOWN();
        this.b = new HashMap();
    }

    public final void a(UpdateRecord r5) {
        LinearLayoutManager r0 = this.a.getLayoutManager();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int r1 = r0.findFirstCompletelyVisibleItemPosition();
        Log.d("FeedScrollStateRecorder", "first visible position = " + r1);
        this.b.put(Long.valueOf(r5.a), Integer.valueOf(r1));
    }
}
