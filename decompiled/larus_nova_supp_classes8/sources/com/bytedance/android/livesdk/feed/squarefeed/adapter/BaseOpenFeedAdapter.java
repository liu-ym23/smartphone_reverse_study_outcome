package com.bytedance.android.livesdk.feed.squarefeed.adapter;

import android.os.Handler;
import android.os.Looper;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.paging.adapter.SimplePagingAdapter;
import com.bytedance.android.live.core.performance.TimeCostUtil;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import g60.c;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class BaseOpenFeedAdapter extends SimplePagingAdapter<FeedItem> {
    public final Handler c;
    public FeedDataKey d;
    public com.bytedance.android.live.core.cache.a<FeedDataKey, FeedItem> e;
    public final Map<String, Long> f;
    public final Map<String, Long> g;
    public Map<String, Long> h;
    public final PublishSubject<Pair<FeedItem, Long>> i;
    public final PublishSubject<FeedItem> j;
    public final PublishSubject<Object> k;
    public final PublishSubject<Object> l;
    public final PublishSubject<Boolean> m;
    public final PublishSubject<Object> n;
    public boolean o;
    public final boolean p;

    public static class a extends DiffUtil.ItemCallback<FeedItem> {
        public a(int r1) {
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

    public BaseOpenFeedAdapter() {
        throw null;
    }

    public BaseOpenFeedAdapter(Map<Integer, b90.a> r3) {
        super(new a(0), r3);
        this.c = new Handler(Looper.getMainLooper());
        this.i = PublishSubject.create();
        PublishSubject<FeedItem> r4 = PublishSubject.create();
        this.j = r4;
        this.k = PublishSubject.create();
        this.l = PublishSubject.create();
        this.m = PublishSubject.create();
        this.n = PublishSubject.create();
        this.p = true;
        this.f = new HashMap();
        this.g = new HashMap();
        r4.subscribe(new uw1.a(this), new c());
    }

    public int D2(int r1) {
        return invalidateType();
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r5) {
        super/*com.bytedance.android.live.core.paging.adapter.PagingAdapter*/.onViewAttachedToWindow(r5);
        if (this.o == false) goto L5;
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
        if (this.p == false) goto L20;
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

    public final int getNormalViewType(int r1, Object r2) {
        FeedItem r3 = (FeedItem) r2;
        if (r3 != null) goto L6;
        return invalidateType();
    L6:
        return D2(r3.type);
    }
}
