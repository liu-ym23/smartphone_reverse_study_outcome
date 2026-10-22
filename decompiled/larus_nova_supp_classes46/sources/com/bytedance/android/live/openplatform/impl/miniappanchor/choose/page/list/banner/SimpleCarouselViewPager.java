package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0007\u000eB'\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010(\u001a\u00020\u0002¢\u0006\u0004\b)\u0010*J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\fR\u0011\u0010\u001a\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u001c\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011R(\u0010#\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006+"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/list/banner/SimpleCarouselViewPager;", "Landroid/widget/FrameLayout;", "", "item", "", "setCurrentItem", "", "a", "Z", "getEnableAutoCarousel", "()Z", "setEnableAutoCarousel", "(Z)V", "enableAutoCarousel", "b", "I", "getAutoCarouselInterval", "()I", "setAutoCarouselInterval", "(I)V", "autoCarouselInterval", "d", "getEnableInfiniteCarousel", "setEnableInfiniteCarousel", "enableInfiniteCarousel", "getCurrentItem", "currentItem", "getCount", "count", "Landroidx/viewpager/widget/PagerAdapter;", "value", "getAdapter", "()Landroidx/viewpager/widget/PagerAdapter;", "setAdapter", "(Landroidx/viewpager/widget/PagerAdapter;)V", "adapter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimpleCarouselViewPager extends FrameLayout {
    public static final /* synthetic */ int h = 0;
    public boolean a;
    public int b;
    public final c c;
    public boolean d;
    public final ViewPager e;
    public final Map<ViewPager.OnPageChangeListener, a> f;
    public b g;

    public final class a implements ViewPager.OnPageChangeListener {
        public final ViewPager.OnPageChangeListener a;
        public final /* synthetic */ SimpleCarouselViewPager b;

        public final void onPageScrollStateChanged(int r3) {
            if (r3 != 1) goto L5;
            SimpleCarouselViewPager r0 = this.b;
            r0.removeCallbacks(r0.c);
        L7:
            this.a.onPageScrollStateChanged(r3);
            return;
        L5:
            if (r3 != 0) goto L7;
            SimpleCarouselViewPager.a(this.b);
            goto L7
        }

        public final void onPageSelected(int r3) {
            int r0 = r3 % this.b.getCount();
            this.a.onPageSelected(r3 % this.b.getCount());
        }

        public a(SimpleCarouselViewPager r2, SimpleCarouselIndicator$setViewPager$2$addOnPageChangeListener$1 r3) {
            Intrinsics.checkNotNullParameter(r3, "realListener");
            this.b = r2;
            this.a = r3;
        }

        public final void onPageScrolled(int r3, float r4, int r5) {
            this.a.onPageScrolled(r3 % this.b.getCount(), r4, r5);
        }
    }

    public final class b extends PagerAdapter {
        public final PagerAdapter a;
        public final /* synthetic */ SimpleCarouselViewPager b;

        public static final class a extends DataSetObserver {
            public final /* synthetic */ b a;

            @Override // android.database.DataSetObserver
            public final void onChanged() {
                this.a.notifyDataSetChanged();
                SimpleCarouselViewPager r0 = this.a.b;
                int r1 = SimpleCarouselViewPager.h;
                if (r0.d == true) goto L5;
                return;
            L5:
                if (r0.getCount() <= 0) goto L9;
                r0.e.setCurrentItem(1073741823 - (1073741823 % r0.getCount()));
                return;
            }

            public a(b r1) {
                this.a = r1;
            }
        }

        public final int f() {
            return this.a.getCount();
        }

        public final int getCount() {
            if (f() != 0) goto L7;
            return 0;
        L7:
            if (this.b.getEnableInfiniteCarousel() == false) goto L10;
            return Integer.MAX_VALUE;
        L10:
            return f();
        }

        public final void finishUpdate(ViewGroup r2) {
            Intrinsics.checkNotNullParameter(r2, "container");
            super.finishUpdate(r2);
            SimpleCarouselViewPager.a(this.b);
        }

        public b(SimpleCarouselViewPager r2, PagerAdapter r3) {
            Intrinsics.checkNotNullParameter(r3, "realPagerAdapter");
            this.b = r2;
            this.a = r3;
            r3.registerDataSetObserver(new a(this));
        }

        public final Object instantiateItem(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "container");
            int r0 = r4 % f();
            return this.a.instantiateItem(r3, r4 % f());
        }

        public final boolean isViewFromObject(View r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "object");
            return this.a.isViewFromObject(r2, r3);
        }

        public final void destroyItem(ViewGroup r3, int r4, Object r5) {
            Intrinsics.checkNotNullParameter(r3, "container");
            Intrinsics.checkNotNullParameter(r5, "object");
            int r0 = r4 % f();
            this.a.destroyItem(r3, r4 % f(), r5);
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ SimpleCarouselViewPager a;

        public c(SimpleCarouselViewPager r1) {
            this.a = r1;
        }

        public final void a() {
            if (this.a.getCount() > 0) goto L6;
            return;
        L6:
            if (this.a.getEnableInfiniteCarousel() == false) goto L8;
            int r0 = this.a.e.getCurrentItem() + 1;
            this.a.e.setCurrentItem(r0, true);
        L20:
            SimpleCarouselViewPager.a(this.a);
            return;
        L8:
            int r1 = this.a.getCurrentItem() + 1;
            if (r1 != this.a.getCount()) goto L11;
            return;
        L11:
            SimpleCarouselViewPager r2 = this.a;
            int r3 = r2.getCount();
            if (r1 < 0) goto L16;
            if (r3 <= r1) goto L16;
            boolean r4 = true;
        L17:
            if (r4 == false) goto L20;
            int r5 = r2.e.getCurrentItem();
            int r6 = r2.getCurrentItem();
            r2.e.setCurrentItem(r5 + (r1 - r6), true);
        L16:
            r4 = false;
            goto L17
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
    }

    public SimpleCarouselViewPager(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SimpleCarouselViewPager(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final int getCount() {
        b r0 = this.g;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.f();
    }

    public final int getCurrentItem() {
        if (getCount() != 0) goto L6;
        return 0;
    L6:
        return this.e.getCurrentItem() % getCount();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.c);
    }

    public final PagerAdapter getAdapter() {
        return this.g;
    }

    public final int getAutoCarouselInterval() {
        return this.b;
    }

    public final boolean getEnableAutoCarousel() {
        return this.a;
    }

    public final boolean getEnableInfiniteCarousel() {
        return this.d;
    }

    public static final void a(SimpleCarouselViewPager r3) {
        if (r3.a == true) goto L5;
        return;
    L5:
        if (r3.b <= 0) goto L10;
        r3.removeCallbacks(r3.c);
        r3.postDelayed(r3.c, r3.b);
        return;
    }

    public final void setAdapter(PagerAdapter r3) {
        if (r3 == null) goto L4;
        b r0 = new b(this, r3);
    L5:
        this.g = r0;
        this.e.setAdapter(r0);
        if (this.d == true) goto L8;
        return;
    L8:
        if (getCount() <= 0) goto L12;
        this.e.setCurrentItem(1073741823 - (1073741823 % getCount()));
        return;
    L12:
        return;
    L4:
        r0 = null;
        goto L5
    }

    public final void setAutoCarouselInterval(int r1) {
        this.b = r1;
    }

    public final void setCurrentItem(int r4) {
        int r0 = getCount();
        if (r4 < 0) goto L7;
        if (r0 <= r4) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L10;
        return;
    L10:
        int r2 = this.e.getCurrentItem();
        int r3 = getCurrentItem();
        this.e.setCurrentItem(r2 + (r4 - r3));
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final void setEnableAutoCarousel(boolean r1) {
        this.a = r1;
    }

    public final void setEnableInfiniteCarousel(boolean r1) {
        this.d = r1;
    }

    public SimpleCarouselViewPager(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.b = 3000;
        this.c = new c(this);
        this.f = new LinkedHashMap();
        if (r4 == null) goto L10;
        TypedArray r6 = r3.obtainStyledAttributes(r4, new int[]{2130968881, 2130969958, 2130969960});
        this.a = r6.getBoolean(1, false);     // Catch: Throwable -> L7
        this.b = r6.getInt(0, 3000);     // Catch: Throwable -> L7
        this.d = r6.getBoolean(2, false);     // Catch: Throwable -> L7
        r6.recycle();
    L7:
        th = move-exception;
        r6.recycle();
        throw th;
    L10:
        ViewPager r7 = new ViewPager(r3);
        r7.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Unit r8 = Unit.INSTANCE;
        this.e = r7;
        addView(r7);
    }

    public /* synthetic */ SimpleCarouselViewPager(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
