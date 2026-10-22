package com.bytedance.android.livesdk.feed.adapter;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.paging.adapter.SimplePagingAdapter;
import com.bytedance.android.live.core.performance.TimeCostUtil;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.livesdk.feed.ItemRepository;
import com.bytedance.android.livesdk.feed.f;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import g60.c;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mv1.d;
import mv1.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class BaseFeedAdapter extends SimplePagingAdapter<FeedItem> {
    public final Handler c;
    public FeedDataKey d;
    public final f e;
    public final Map<String, Long> f;
    public final Map<String, Long> g;
    public Map<String, Long> h;
    public final PublishSubject<FeedItem> i;
    public final PublishSubject<Object> j;
    public final PublishSubject<Object> k;
    public final PublishSubject<Boolean> l;
    public final PublishSubject<Object> m;
    public boolean n;
    public boolean o;

    public static class ItemComparator extends DiffUtil.ItemCallback<FeedItem> {
        public ItemComparator() {
        }

        public final boolean areContentsTheSame(Object r1, Object r2) {
            int r3 = ((FeedItem) r1).type;
            if (r3 == ((FeedItem) r2).type) goto L5;
        L7:
            return false;
        L5:
            if (r3 != 1003) goto L7;
            return true;
        }

        public final boolean areItemsTheSame(Object r1, Object r2) {
            int r3 = ((FeedItem) r1).type;
            if (r3 == ((FeedItem) r2).type) goto L5;
        L7:
            return false;
        L5:
            if (r3 != 1003) goto L7;
            return true;
        }
    }

    public final FeedItem D2(int r5) {
        ItemRepository r0 = this.e.d(this.d);
        if (r0 != null) goto L7;
        LocalTestManager.a(new Class[]{wy.a.class});
        return null;
    L7:
        if (Lists.isEmpty(r0.getFeedItems()) == true) goto L15;
        if (r5 < 0) goto L15;
        if (r5 >= r0.getFeedItems().size()) goto L15;
        if (((FeedItem) ListProtector.get(this.e.d(this.d).getFeedItems(), r5)).getItem() == null) goto L15;
        return r0.getFeedItem(((FeedItem) ListProtector.get(this.e.d(this.d).getFeedItems(), r5)).getItem().getMixId());
    L15:
        return null;
    }

    public int E2(int r1) {
        return invalidateType();
    }

    public final void F2(Map r2) {
        if (r2 == null) goto L8;
        HashMap r3 = (HashMap) r2;
        if (r3.size() == 0) goto L9;
        r3.clear();
        return;
    L9:
        return;
    }

    public final void G2(boolean r7) {
        this.o = r7;
        if (r7 == true) goto L5;
        F2(this.f);
    L14:
        this.l.onNext(Boolean.valueOf(r7));
        return;
    L5:
        Map<String, Long> r0 = this.h;
        if (r0 == null) goto L14;
        if (((HashMap) r0).size() == 0) goto L14;
        long r1 = TimeUtils.currentTimeMillis();
        Iterator r2 = ((HashMap) this.h).entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        String r3 = (String) ((Map.Entry) r2.next()).getKey();
        Map<String, Long> r4 = this.f;
        HashMap r5 = (HashMap) r4;
        r5.put(r3, Long.valueOf(r1));
        goto L11
    L13:
        ((HashMap) this.h).clear();
        this.h = null;
        goto L14
    }

    public final void H2(l r3) {
        this.d = r3.a();
        ((SimplePagingAdapter) this).b = new Object[]{r3, this.i, this.j, this.k, this.l, this.m};
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder r5) {
        super/*com.bytedance.android.live.core.paging.adapter.PagingAdapter*/.onViewAttachedToWindow(r5);
        if (this.n == false) goto L5;
        return;
    L5:
        int r0 = mappingAdapterPos2DataPos(r5.getAdapterPosition());
        if (r0 >= 0) goto L8;
    L23:
        TimeCostUtil.Tag r1 = TimeCostUtil.Tag.LiveFeedInit;
        TimeCostUtil.a("viewholder", r5.getClass().toString());
        com.bytedance.android.live.core.performance.a r6 = com.bytedance.android.live.core.performance.a.a;
        r1.name();
        r6.getClass();
        return;
    L8:
        if (r0 >= mappingAdapterPos2DataPos(getItemCount())) goto L23;
        FeedItem r2 = (FeedItem) getItem(r0);
        if (r2 == null) goto L23;
        if (r2.getItem() == null) goto L23;
        String r3 = r2.getItem().getMixId();
        if (this.o == false) goto L20;
        if (((HashMap) this.f).get(r3) != null) goto L23;
        Map<String, Long> r4 = this.f;
        HashMap r7 = (HashMap) r4;
        r7.put(r3, Long.valueOf(TimeUtils.currentTimeMillis()));
        goto L23
    L20:
        if (this.h != null) goto L22;
        this.h = new HashMap();
    L22:
        ((HashMap) this.h).put(r3, -1L);
        goto L23
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r6) {
        super/*com.bytedance.android.live.core.paging.adapter.PagingAdapter*/.onViewDetachedFromWindow(r6);
        int r7 = mappingAdapterPos2DataPos(r6.getAdapterPosition());
        if (r7 >= 0) goto L5;
        return;
    L5:
        if (r7 >= mappingAdapterPos2DataPos(getItemCount())) goto L19;
        FeedItem r8 = (FeedItem) getItem(r7);
        if (r8 != null) goto L9;
        return;
    L9:
        if (r8.getItem() == null) goto L22;
        String r9 = r8.getItem().getMixId();
        if (((HashMap) this.f).get(r9) == null) goto L21;
        long r0 = ((Long) ((HashMap) this.f).get(r9)).longValue();
        Long r2 = (Long) ((HashMap) this.g).get(r9);
        if (r2 != null) goto L16;
        r2 = 0L;
    L16:
        long r3 = TimeUtils.currentTimeMillis() - r0;
        Map<String, Long> r1 = this.g;
        HashMap r4 = (HashMap) r1;
        r4.put(r9, Long.valueOf(r2.longValue() + r3));
        ((HashMap) this.f).remove(r9);
        return;
    L21:
        return;
    L22:
        return;
    }

    public BaseFeedAdapter(Map<Integer, b90.a> r2, f r3) {
        this(new ItemComparator(), r2, r3);
    }

    public final int getNormalViewType(int r1, Object r2) {
        FeedItem r3 = (FeedItem) r2;
        if (r3 != null) goto L6;
        return invalidateType();
    L6:
        return E2(r3.type);
    }

    public BaseFeedAdapter(DiffUtil.ItemCallback<FeedItem> r1, Map<Integer, b90.a> r2, f r3) {
        super(r1, r2);
        this.c = new Handler(Looper.getMainLooper());
        PublishSubject<FeedItem> r4 = PublishSubject.create();
        this.i = r4;
        this.j = PublishSubject.create();
        this.k = PublishSubject.create();
        this.l = PublishSubject.create();
        this.m = PublishSubject.create();
        this.o = true;
        this.e = r3;
        this.f = new HashMap();
        this.g = new HashMap();
        r4.subscribe(new d(this), new c());
    }
}
