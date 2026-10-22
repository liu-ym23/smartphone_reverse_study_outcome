package e60;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import com.bytedance.android.live.core.cache.j;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<CacheKey, T> extends a<T> {
    public final com.bytedance.android.live.core.cache.a<CacheKey, T> l;
    public final CacheKey m;

    @Override // e60.a, com.bytedance.android.live.core.paging.Listing
    public final int size() {
        return this.l.size(this.m);
    }

    @Override // e60.a, com.bytedance.android.live.core.paging.Listing
    public final T find(j<T> r3) {
        return this.l.c(this.m, r3);
    }

    @Override // e60.a, com.bytedance.android.live.core.paging.Listing
    public final T get(int r3) {
        return this.l.get(this.m, r3);
    }

    @Override // e60.a, com.bytedance.android.live.core.paging.Listing
    public final int indexOf(T r3) {
        return this.l.a(this.m, r3);
    }

    @Override // e60.a, com.bytedance.android.live.core.paging.Listing
    public final void remove(int r3) {
        this.l.delete(this.m, r3);
        update();
    }

    @Override // e60.a, com.bytedance.android.live.core.paging.Listing
    public final void remove(T r3) {
        this.l.delete(this.m, r3);
        update();
    }

    public b(f60.a<CacheKey, T> r1, LiveData<PagedList<T>> r2) {
        super(r1, r2);
        this.m = r1.n;
        this.l = r1.o;
    }

    @Override // e60.a, com.bytedance.android.live.core.paging.Listing
    public final void add(int r3, T r4) {
        this.l.insert(this.m, r3, r4);
        update();
    }

    @Override // e60.a, com.bytedance.android.live.core.paging.Listing
    public final void put(int r3, T r4) {
        this.l.b(this.m, r3, r4);
        update();
    }

    @Override // e60.a, com.bytedance.android.live.core.paging.Listing
    public final void add(int r3, List<T> r4) {
        this.l.insert(this.m, r3, r4);
        update();
    }
}
