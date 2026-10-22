package mv1;

import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.utils.r1;
import com.bytedance.android.live.multilink.impl.o1;
import com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.adapter.BaseFeedAdapter;
import com.bytedance.android.livesdk.feed.viewmodel.BaseFeedDataViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k {
    public final BaseFeedAdapter a;
    public final RecyclerView b;
    public final BaseFeedDataViewModel c;
    public RecyclerView.LayoutManager d;
    public RecyclerView.ItemDecoration e;
    public final LifecycleOwner f;
    public boolean g;
    public c h;
    public BannerSwipeRefreshLayout.a i;
    public String j;
    public boolean k;
    public boolean l;
    public final a m;

    public class a implements Observer<Integer> {
        public final /* synthetic */ k a;

        public a(k r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Integer r4 = (Integer) r3;
            if (r4 == null) goto L12;
            RecyclerView r0 = this.a.b;
            if (r0 == null) goto L14;
            r1.a(r0, 0);
            if (this.a.c.scrollTop() == false) goto L10;
            r1.a(this.a.b, r4.intValue());
            return;
        L10:
            this.a.b.scrollToPosition(r4.intValue());
            return;
        L14:
            return;
        }
    }

    public static class b {
        public BaseFeedAdapter a;
        public RecyclerView b;
        public BaseFeedDataViewModel c;
        public RecyclerView.LayoutManager d;
        public int e;
        public RecyclerView.ItemDecoration f;
        public LifecycleOwner g;
        public boolean h;
        public c i;
        public BannerSwipeRefreshLayout.a j;
        public String k;

        public final k a() {
            RecyclerView r0 = this.b;
            if (r0 == null) goto L22;
            r0.setItemAnimator(null);
            BaseFeedAdapter r1 = this.a;
            if (r1 == null) goto L20;
            BaseFeedDataViewModel r2 = this.c;
            if (r2 == null) goto L18;
            LifecycleOwner r3 = this.g;
            if (r3 == null) goto L16;
            k r4 = new k(r3, r1, this.b, r2);
            StaggeredGridLayoutManager r5 = this.d;
            r4.d = r5;
            if ((r5 instanceof StaggeredGridLayoutManager) == false) goto L13;
            r5.setSpanCount(this.e);
        L13:
            r4.h = this.i;
            r4.e = this.f;
            r4.g = this.h;
            r4.i = this.j;
            r4.j = this.k;
            r4.k = false;
            return r4;
        L16:
            throw new IllegalStateException("lifecycleOwner must not be null");
        L18:
            throw new IllegalStateException("viewModel must not be null");
        L20:
            throw new IllegalStateException("adapter must not be null");
        L22:
            throw new IllegalStateException("recyclerView must not be null");
        }

        public b() {
            this.e = 2;
            StaggeredGridLayoutManager r1 = new StaggeredGridLayoutManager(2, 1);
            r1.setGapStrategy(0);
            this.d = r1;
        }
    }

    public interface c {
        void a(FeedItem r1);
    }

    public final void a() {
        this.a.H2(new i(this));
        this.b.setAdapter(this.a);
        this.a.setRecyclerView(this.b);
        this.b.setLayoutManager(this.d);
        this.b.addOnScrollListener(new j(this));
        RecyclerView.ItemDecoration r0 = this.e;
        if (r0 == null) goto L5;
        this.b.addItemDecoration(r0);
    L5:
        this.a.setViewModel(this.c);
        this.a.i.subscribe(new e(this), new o1());
        this.a.j.subscribe(new f(this), new o1());
        this.c.start();
        this.c.feedRepository().vK(this.f);
        this.c.pos().observeForever(this.m);
        this.c.userStatus().observe(this.f, new g(this));
        this.c.refreshApiStatus().observe(this.f, new h(this));
    }

    public k(LifecycleOwner r2, BaseFeedAdapter r3, RecyclerView r4, BaseFeedDataViewModel r5) {
        this.m = new a(this);
        this.f = r2;
        this.a = r3;
        this.b = r4;
        this.c = r5;
    }
}
