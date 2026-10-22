package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.banner.BannerViewHolder;
import com.bytedance.android.livesdk.feed.banner.RoundIndicatorView;
import com.bytedance.android.livesdk.feed.banner.adapter.BannerPageAdapter;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class DrawerBannerViewHolder extends BaseViewHolder<FeedItem> {
    public static final /* synthetic */ int k = 0;
    public final ViewPager a;
    public final RoundIndicatorView b;
    public BannerPageAdapter c;
    public final BannerViewHolder.a d;
    public final BannerViewHolder.PageChangeListener e;
    public List<com.bytedance.android.live.base.model.banner.a> f;
    public final String g;
    public boolean h;
    public final com.bytedance.android.livesdk.feed.l i;
    public final ViewGroup j;

    public final boolean fullSpan() {
        return true;
    }

    public final void U3() {
        if (this.h == false) goto L22;
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.getVisibility() != 0) goto L28;
        T3(this.f);
        List<com.bytedance.android.live.base.model.banner.a> r1 = this.f;
        if (r1 != null) goto L12;
        return;
    L12:
        if (r1.size() <= 1) goto L25;
        ViewPager r2 = this.a;
        if (r2 != null) goto L16;
        return;
    L16:
        if (this.b == null) goto L27;
        BannerViewHolder.PageChangeListener r3 = this.e;
        if (r3 == null) goto L20;
        r3.d = true;
    L20:
        r2.clearOnPageChangeListeners();
        this.a.addOnPageChangeListener(this.e);
        this.b.setViewPager(this.a);
        ViewPager r4 = this.a;
        BannerViewHolder.a r5 = this.d;
        r4.removeCallbacks(r5);
        r4.postDelayed(r5, 5000);
        return;
    L27:
        return;
    L25:
        return;
    L28:
        return;
    }

    public final void V3() {
        this.a.removeCallbacks(this.d);
        this.a.clearOnPageChangeListeners();
        BannerViewHolder.PageChangeListener r0 = this.e;
        if (r0 == null) goto L6;
        r0.d = false;
        return;
    }

    public final void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
        this.h = true;
        BannerViewHolder.PageChangeListener r1 = this.e;
        if (r1 == null) goto L5;
        r1.f = true;
    L5:
        U3();
    }

    public final void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        this.h = false;
        BannerViewHolder.PageChangeListener r1 = this.e;
        if (r1 == null) goto L5;
        r1.f = false;
    L5:
        V3();
    }

    public final void T3(List<com.bytedance.android.live.base.model.banner.a> r4) {
        BannerViewHolder.PageChangeListener r0 = this.e;
        if (r0 == null) goto L5;
        int r1 = r0.e;
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        if (r4.isEmpty() == false) goto L10;
        return;
    L10:
        if (this.h == false) goto L25;
        com.bytedance.android.live.base.model.banner.a r5 = (com.bytedance.android.live.base.model.banner.a) ListProtector.get(r4, r1 % r4.size());
        HashMap r2 = new HashMap();
        r2.put("show_source", this.g);
        r2.put("banner_id", String.valueOf(r5.getId()));
        r2.put("banner_page", "more_anchor");
        if (e5.n() == false) goto L14;
        String r6 = "landscape";
    L15:
        r2.put("screen_direction", r6);
        String r7 = TTLiveService.getLiveService().getLiveOntologyRecord().getEnterFromMerge();     // Catch: Exception -> L18
    L19:
        r2.put("enter_from_merge", r7);
        r2.put("enter_method", "drawer_cover");
        kw1.c.d("banner_show", r2);
        return;
    L18:
        r7 = "drawer_null";
        goto L19
    L14:
        r6 = "portrait";
        goto L15
    L25:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final void bind(Object r8, int r9) {
        FeedItem r10 = (FeedItem) r8;
        if (r10 == null) goto L70;
        List<com.bytedance.android.live.base.model.banner.a> r11 = r10.banners;
        if (r11 == null) goto L74;
        List<com.bytedance.android.live.base.model.banner.a> r12 = this.f;
        if (r12 == r11) goto L28;
        if (r12 != null) goto L13;
    L26:
        boolean r13 = false;
    L29:
        if (r13 == true) goto L71;
        T3(r11);
        this.a.removeCallbacks(this.d);
        this.f = r11;
        this.a.setAdapter(null);
        if (r11.isEmpty() == true) goto L57;
        ViewGroup.LayoutParams r14 = this.a.getLayoutParams();
        Iterator<com.bytedance.android.live.base.model.banner.a> r2 = r11.iterator();
    L34:
        if (r2.hasNext() == false) goto L40;
        com.bytedance.android.live.base.model.banner.a r4 = r2.next();
        if (r4 == null) goto L34;
        if (r4.h() == 0) goto L34;
        int r3 = (this.j.getMeasuredWidth() * r4.b()) / r4.h();
    L42:
        if (r3 == r14.height) goto L45;
        r14.height = r3;
        this.a.setLayoutParams(r14);
    L45:
        if (this.c != null) goto L47;
        this.c = new BannerPageAdapter(((RecyclerView.ViewHolder) this).itemView.getContext(), LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.g, this.i);
    L47:
        BannerPageAdapter r15 = this.c;
        List<com.bytedance.android.live.base.model.banner.a> r5 = this.f;
        ((ArrayList) r15.a).clear();
        if (r5 == null) goto L50;
        ((ArrayList) r15.a).addAll(r5);
    L50:
        r15.notifyDataSetChanged();
        this.a.setAdapter(this.c);
        if (this.f.size() <= 1) goto L56;
        ViewPager r16 = this.a;
        BannerViewHolder.a r6 = this.d;
        r16.removeCallbacks(r6);
        r16.postDelayed(r6, 5000);
        this.a.clearOnPageChangeListeners();
        this.a.addOnPageChangeListener(this.e);
        BannerViewHolder.PageChangeListener r17 = this.e;
        if (r17 == null) goto L55;
        r17.d = true;
    L55:
        this.b.setViewPager(this.a);
        this.b.setVisibility(0);
        this.b.setCount(r11.size());
        this.a.setCurrentItem(this.f.size() * (Integer.MAX_VALUE / (this.f.size() * 2)));
        return;
    L56:
        this.b.setVisibility(8);
        return;
    L40:
        r3 = 0;
        goto L42
    L57:
        ViewGroup.LayoutParams r18 = this.a.getLayoutParams();
        r18.height = 0;
        this.a.setLayoutParams(r18);
        this.c = null;
        this.b.setVisibility(8);
        return;
    L71:
        return;
    L13:
        if (r12.size() != r11.size()) goto L26;
        int r7 = 0;
    L17:
        if (r7 >= r12.size()) goto L28;
        com.bytedance.android.live.base.model.banner.a r19 = (com.bytedance.android.live.base.model.banner.a) ListProtector.get(r12, r7);
        com.bytedance.android.live.base.model.banner.a r20 = (com.bytedance.android.live.base.model.banner.a) ListProtector.get(r11, r7);
        if (r19 != null) goto L21;
    L23:
        if (r20 == null) goto L27;
        if (r20.a(r19) == false) goto L26;
    L27:
        r7 = r7 + 1;
        goto L17
    L21:
        if (r19.a(r20) == true) goto L23;
    L28:
        r13 = true;
        goto L29
    L74:
        return;
    }

    public DrawerBannerViewHolder(View r3, BannerSwipeRefreshLayout.a r4, FeedDataKey r5, PublishSubject<Object> r6, PublishSubject<Object> r7, PublishSubject<Boolean> r8, com.bytedance.android.livesdk.feed.l r9, ViewGroup r10) {
        super(r3);
        this.j = r10;
        ViewPager r11 = r3.findViewById(2131392622);
        this.a = r11;
        RoundIndicatorView r0 = (RoundIndicatorView) r3.findViewById(2131375226);
        this.b = r0;
        r3.getContext();
        String r12 = r5.b;
        this.g = r12;
        this.i = r9;
        BannerViewHolder.a r13 = new BannerViewHolder.a(r11);
        this.d = r13;
        r11.removeCallbacks(r13);
        BannerViewHolder.PageChangeListener r1 = new BannerViewHolder.PageChangeListener(r11, r13, r12);
        this.e = r1;
        r11.setOnTouchListener(new a(this));
        r0.setViewPager(r11);
        ViewPager r14 = r0.k;
        if (r14 == null) goto L5;
        r14.addOnPageChangeListener(r1);
    L5:
        if (r4 == null) goto L7;
        r4.a(r11, r3);
    L7:
        r8.subscribe(new b(this), new g60.c());
        r6.subscribe(new c(this), new g60.c());
        r7.subscribe(new d(this), new g60.c());
    }
}
