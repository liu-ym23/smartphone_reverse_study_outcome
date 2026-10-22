package com.bytedance.android.livesdk.interactivity.api.input.viewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.uikit.viewpager.SSViewPager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/input/viewpager/InputSectionPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InputSectionPagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    public final ArrayList<Function2<Integer, b, Unit>> a;
    public final HashMap<Integer, a> b;
    public int c;
    public int d;
    public final List<b> e;
    public final Context f;
    public final ViewPager g;

    public final void onPageScrollStateChanged(int r1) {
    }

    public final void onPageScrolled(int r1, float r2, int r3) {
    }

    public final int getCount() {
        return this.d;
    }

    public final void f(int r5) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Function2) r0.next()).invoke(Integer.valueOf(r5), ListProtector.get(this.e, r5));
        goto L4
    }

    public final void onPageSelected(int r1) {
        this.c = r1;
        f(r1);
    }

    public InputSectionPagerAdapter(Context r2, SSViewPager r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "viewPager");
        this.f = r2;
        this.g = r3;
        r3.setAdapter(this);
        r3.addOnPageChangeListener(this);
        this.a = new ArrayList();
        this.b = new HashMap();
        this.e = new ArrayList();
    }

    public final Object instantiateItem(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "container");
        b r0 = (b) ListProtector.get(this.e, r6);
        View r1 = r0.c(this.f);
        a r2 = r0.a(this.f, r1);
        r2.a();
        r5.addView(r2.getRootView(), -1, new ViewGroup.LayoutParams(-1, -1));
        this.b.put(Integer.valueOf(r6), r2);
        return r2;
    }

    public final boolean isViewFromObject(View r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        Intrinsics.checkNotNullParameter(r3, "p1");
        if ((r3 instanceof a) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r2, ((a) r3).getRootView());
    }

    public final void destroyItem(ViewGroup r2, int r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r4, "sectionPage");
        if ((r4 instanceof a) == false) goto L6;
        a r5 = (a) r4;
        r5.unbind();
        r2.removeView(r5.getRootView());
        this.b.remove(Integer.valueOf(r3));
        return;
    }
}
