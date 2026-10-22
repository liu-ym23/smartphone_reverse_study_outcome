package com.bytedance.android.livesdk.feed.banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.banner.adapter.BannerPageAdapter;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.l;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.subjects.PublishSubject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kw1.c;
import ov1.b;
import ov1.d;
import ov1.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class BannerViewHolder extends BaseViewHolder<FeedItem> {
    public static final /* synthetic */ int k = 0;
    public final ViewPager a;
    public final RoundIndicatorView b;
    public BannerPageAdapter c;
    public final a d;
    public final PageChangeListener e;
    public List<com.bytedance.android.live.base.model.banner.a> f;
    public final Context g;
    public final String h;
    public boolean i;
    public final l j;

    public static class PageChangeListener implements ViewPager.OnPageChangeListener {
        public final ViewPager a;
        public final a b;
        public final String c;
        public boolean d;
        public int e;
        public boolean f;

        public final void onPageScrollStateChanged(int r1) {
        }

        public final void onPageScrolled(int r1, float r2, int r3) {
        }

        /* JADX WARN: Type inference failed for: r5v14, types: [android.view.ViewGroup, com.bytedance.android.livesdk.feed.banner.BannerViewPager] */
        public final void onPageSelected(int r5) {
            this.e = r5;
            if (this.d == true) goto L5;
            return;
        L5:
            ViewPager r0 = this.a;
            a r1 = this.b;
            int r2 = BannerViewHolder.k;
            r0.removeCallbacks(r1);
            r0.postDelayed(r1, 5000);
            if (this.f == true) goto L9;
            return;
        L9:
            if (this.a.getAdapter() != null) goto L11;
            return;
        L11:
            BannerPageAdapter r3 = this.a.getAdapter();
            List<com.bytedance.android.live.base.model.banner.a> r4 = r3.a;
            if (r4 != null) goto L14;
        L18:
            com.bytedance.android.live.base.model.banner.a r6 = null;
        L19:
            if (r6 != null) goto L21;
            return;
        L21:
            HashMap r7 = new HashMap();
            r7.put("show_source", this.c);
            r7.put("banner_id", String.valueOf(r6.getId()));
            r7.put("banner_page", "more_anchor");
            List<com.bytedance.android.live.base.model.banner.a> r8 = this.a.getAdapter().a;
            if (r8 != null) goto L24;
            int r9 = 0;
        L26:
            if (r9 <= 0) goto L28;
            r7.put("index", String.valueOf((this.e % r9) + 1));
        L28:
            c.d("banner_show", r7);
            ViewPager r10 = this.a;
            if ((r10 instanceof BannerViewPager) == false) goto L39;
            final ?? r11 = (BannerViewPager) r10;
            MotionEvent r12 = r11.c;
            if (r12 != null) goto L33;
        L36:
            r11.post(new e(r11));
        L37:
            Logger.d("BannerViewPager", "onPageSelected ");
            return;
        L33:
            if (r12.getAction() == 3) goto L36;
            if (r11.c.getAction() != 1) goto L37;
        L39:
            return;
        L24:
            r9 = ((ArrayList) r8).size();
            goto L26
        L14:
            if (((ArrayList) r4).isEmpty() == true) goto L18;
            if (r5 < 0) goto L18;
            int r13 = r5 % ((ArrayList) r3.a).size();
            r6 = (com.bytedance.android.live.base.model.banner.a) ListProtector.get(r3.a, r13);
            goto L19
        }

        public PageChangeListener(ViewPager r2, a r3, String r4) {
            this.e = 0;
            this.f = true;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static class a implements Runnable {
        public final ViewPager a;

        public final void a() {
            Field r1 = ViewPager.class.getDeclaredField("mFirstLayout");     // Catch: Exception -> L5
            r1.setAccessible(true);     // Catch: Exception -> L5
            r1.set(this.a, Boolean.FALSE);     // Catch: Exception -> L5
            r1.setAccessible(false);     // Catch: Exception -> L5
            Class r6 = Integer.TYPE;     // Catch: Exception -> L5
            Class r7 = Boolean.TYPE;     // Catch: Exception -> L5
            Method r2 = ViewPager.class.getDeclaredMethod("setCurrentItemInternal", new Class[]{r6, r7, r7, r6});     // Catch: Exception -> L5
            r2.setAccessible(true);     // Catch: Exception -> L5
            ViewPager r3 = this.a;     // Catch: Exception -> L5
            Boolean r5 = Boolean.TRUE;     // Catch: Exception -> L5
            r2.invoke(r3, new Object[]{Integer.valueOf(r3.getCurrentItem() + 1), r5, r5, 1});     // Catch: Exception -> L5
            r2.setAccessible(false);     // Catch: Exception -> L5
            return;
        L5:
            ViewPager r4 = this.a;
            r4.setCurrentItem(r4.getCurrentItem() + 1);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ViewPager r1) {
            this.a = r1;
        }
    }

    public final boolean fullSpan() {
        return true;
    }

    public final void U3() {
        if (this.i == false) goto L22;
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
        PageChangeListener r3 = this.e;
        if (r3 == null) goto L20;
        r3.d = true;
    L20:
        r2.clearOnPageChangeListeners();
        this.a.addOnPageChangeListener(this.e);
        this.b.setViewPager(this.a);
        ViewPager r4 = this.a;
        a r5 = this.d;
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
        PageChangeListener r0 = this.e;
        if (r0 == null) goto L6;
        r0.d = false;
        return;
    }

    public final void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
        this.i = true;
        PageChangeListener r1 = this.e;
        if (r1 == null) goto L5;
        r1.f = true;
    L5:
        U3();
    }

    public final void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        this.i = false;
        PageChangeListener r1 = this.e;
        if (r1 == null) goto L5;
        r1.f = false;
    L5:
        V3();
    }

    public final void T3(List<com.bytedance.android.live.base.model.banner.a> r6) {
        PageChangeListener r0 = this.e;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.e;
    L6:
        if (r6 != null) goto L8;
        return;
    L8:
        if (r6.isEmpty() == false) goto L10;
        return;
    L10:
        if (this.i == false) goto L21;
        int r3 = r2 % r6.size();
        com.bytedance.android.live.base.model.banner.a r7 = (com.bytedance.android.live.base.model.banner.a) ListProtector.get(r6, r3);
        HashMap r4 = new HashMap();
        r4.put("show_source", this.h);
        r4.put("banner_id", String.valueOf(r7.getId()));
        r4.put("banner_page", "more_anchor");
        List<com.bytedance.android.live.base.model.banner.a> r8 = this.a.getAdapter().a;
        if (r8 == null) goto L15;
        r1 = ((ArrayList) r8).size();
    L15:
        if (r1 <= 0) goto L17;
        r4.put("index", String.valueOf((r3 % r1) + 1));
    L17:
        c.d("banner_show", r4);
        return;
    L21:
        return;
    L5:
        r2 = 0;
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
        int r3 = (UIUtils.getScreenWidth(this.g) * r4.b()) / r4.h();
    L42:
        if (r3 == r14.height) goto L45;
        r14.height = r3;
        this.a.setLayoutParams(r14);
    L45:
        if (this.c != null) goto L47;
        this.c = new BannerPageAdapter(((RecyclerView.ViewHolder) this).itemView.getContext(), LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.h, this.j);
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
        a r6 = this.d;
        r16.removeCallbacks(r6);
        r16.postDelayed(r6, 5000);
        this.a.clearOnPageChangeListeners();
        this.a.addOnPageChangeListener(this.e);
        PageChangeListener r17 = this.e;
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

    public BannerViewHolder(View r4, BannerSwipeRefreshLayout.a r5, FeedDataKey r6, PublishSubject<Object> r7, PublishSubject<Object> r8, PublishSubject<Boolean> r9, l r10) {
        super(r4);
        ViewPager r0 = r4.findViewById(2131392622);
        this.a = r0;
        RoundIndicatorView r1 = (RoundIndicatorView) r4.findViewById(2131375226);
        this.b = r1;
        this.g = r4.getContext();
        String r11 = r6.b;
        this.h = r11;
        this.j = r10;
        a r12 = new a(r0);
        this.d = r12;
        r0.removeCallbacks(r12);
        PageChangeListener r2 = new PageChangeListener(r0, r12, r11);
        this.e = r2;
        r0.setOnTouchListener(new ov1.a(this));
        r1.setViewPager(r0);
        ViewPager r13 = r1.k;
        if (r13 == null) goto L5;
        r13.addOnPageChangeListener(r2);
    L5:
        if (r5 == null) goto L7;
        r5.a(r0, r4);
    L7:
        r9.subscribe(new b(this), new g60.c());
        r7.subscribe(new ov1.c(this), new g60.c());
        r8.subscribe(new d(this), new g60.c());
    }
}
