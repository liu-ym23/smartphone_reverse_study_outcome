package com.bytedance.android.livesdk.feed;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.utils.NoNullRepeatList;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.common.utility.Lists;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements f {
    public final Map<FeedDataKey, a> a;
    public final PublishSubject<FeedDataKey> b;
    public final com.bytedance.android.live.core.cache.a<FeedDataKey, FeedItem> c;
    public final List<com.bytedance.android.livesdk.feed.feed.d> d;
    public final NoNullRepeatList e;

    public static class a {
        public ItemRepository a;
        public int b;

        public a(ItemRepository r1) {
            this.a = r1;
            this.b = 0;
        }
    }

    public d(com.bytedance.android.live.core.cache.i r2) {
        this.a = new ConcurrentHashMap();
        BehaviorSubject.createDefault(Boolean.FALSE);
        this.b = PublishSubject.create();
        PublishSubject.create();
        this.d = new LinkedList();
        this.e = new NoNullRepeatList();
        this.c = r2;
    }

    @Override // com.bytedance.android.livesdk.feed.f
    public final void b(f.a r2) {
        this.e.remove(r2);
    }

    @Override // com.bytedance.android.livesdk.feed.f
    public final void c(com.bytedance.android.livesdk.feed.feed.d r2) {
        ((LinkedList) this.d).add(r2);
    }

    @Override // com.bytedance.android.livesdk.feed.f
    public final ItemRepository d(FeedDataKey r2) {
        a r3 = (a) ((ConcurrentHashMap) this.a).get(r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        return r3.a;
    }

    @Override // com.bytedance.android.livesdk.feed.f
    public final void f(com.bytedance.android.livesdk.feed.feed.d r2) {
        ((LinkedList) this.d).remove(r2);
    }

    @Override // com.bytedance.android.livesdk.feed.f
    public final void i(f.a r2) {
        this.e.add(r2);
    }

    @Override // com.bytedance.android.livesdk.feed.f
    public final void e(FeedDataKey r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        if (r2 == null) goto L9;
        a r4 = (a) ((ConcurrentHashMap) this.a).get(r2);
        if (r4 == null) goto L9;
        r4.a.Gf(r3);
    L9:
        Iterator r5 = this.e.iterator();
    L11:
        if (r5.hasNext() == false) goto L15;
        f.a r0 = (f.a) r5.next();
        if (r0 == null) goto L11;
        r0.a(r3);
        goto L11
    }

    @Override // com.bytedance.android.livesdk.feed.f
    public final void g(FeedDataKey r3, ItemRepository r4) {
        if (r3 == null) goto L13;
        if (r4 == null) goto L14;
        a r0 = (a) ((ConcurrentHashMap) this.a).get(r3);
        if (r0 != null) goto L9;
        r0 = new a(r4);
        ((ConcurrentHashMap) this.a).put(r3, r0);
        this.b.onNext(r3);
    L9:
        if (r0.a == r4) goto L11;
        r0.a = r4;
    L11:
        r0.b++;
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.f
    public final boolean h(FeedDataKey r3, ItemRepository r4) {
        if (r3 == null) goto L16;
        if (r4 == null) goto L18;
        a r5 = (a) ((ConcurrentHashMap) this.a).get(r3);
        if (r5 == null) goto L11;
        int r1 = r5.b - 1;
        r5.b = r1;
        if (r1 > 0) goto L11;
        ((ConcurrentHashMap) this.a).remove(r3);
    L11:
        if (r5 != null) goto L13;
    L14:
        return true;
    L13:
        if (r5.b == 0) goto L14;
        return false;
    L18:
        return false;
    L16:
        return false;
    }

    @Override // com.bytedance.android.livesdk.feed.f
    public final void a(String r3, List<FeedItem> r4, FeedExtra r5, boolean r6) {
        if (Lists.notEmpty(this.d) == false) goto L8;
        Iterator<com.bytedance.android.livesdk.feed.feed.d> r0 = this.d.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        r0.next().a(r3, r4, r5, r6);
        goto L6
    L10:
        return;
    }
}
