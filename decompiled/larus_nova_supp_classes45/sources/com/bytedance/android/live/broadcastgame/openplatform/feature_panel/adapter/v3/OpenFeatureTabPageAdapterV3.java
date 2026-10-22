package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.v3;

import a20.e;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import c20.a;
import c20.d;
import com.bytedance.android.live.broadcastgame.api.model.n0;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.OpenFeatureTabListAdapter;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base.OpenFeatureIconCallbackFrom;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.config.ft0;
import com.bytedance.android.livesdk.config.k81;
import com.bytedance.android.livesdk.widget.LivePagerSlidingTabStrip;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import f10.f;
import g20.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/adapter/v3/OpenFeatureTabPageAdapterV3;", "Landroidx/viewpager/widget/PagerAdapter;", "Lcom/bytedance/android/livesdk/widget/LivePagerSlidingTabStrip$b;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenFeatureTabPageAdapterV3 extends PagerAdapter implements LivePagerSlidingTabStrip.b {
    public final ArrayList<a> a;
    public final ArrayList<d> b;
    public final Map<Integer, WeakReference<RecyclerView>> c;
    public Function3<? super RecyclerView, ? super LinearLayoutManager, ? super Integer, Unit> d;
    public final e e;
    public final LivePagerSlidingTabStrip f;
    public final ViewPager g;
    public final List<b20.e> h;

    public final int getCount() {
        return this.b.size();
    }

    public final void f(int r7) {
        if (r7 >= 0) goto L4;
        return;
    L4:
        if (r7 >= this.b.size()) goto L44;
        n0 r0 = ((d) ListProtector.get(this.b, r7)).c;
        if (r0 == null) goto L45;
        WeakReference r1 = (WeakReference) ((LinkedHashMap) this.c).get(Integer.valueOf(r7));
        RecyclerView.Adapter r2 = null;
        if (r1 == null) goto L12;
        RecyclerView r3 = (RecyclerView) r1.get();
        if (r3 == null) goto L12;
        RecyclerView.Adapter r4 = r3.getAdapter();
    L14:
        if ((r4 instanceof OpenFeatureTabListAdapter) == false) goto L17;
        r2 = r4;
    L17:
        OpenFeatureTabListAdapter r5 = (OpenFeatureTabListAdapter) r2;
        if (r5 == null) goto L46;
        a r8 = (a) ListProtector.get(this.a, r7);
        List<f> r9 = i(Long.valueOf(r8.a), r8.b);
        if (TextUtils.isEmpty(r0.a) == true) goto L31;
        ArrayList r6 = new ArrayList();
        Iterator r11 = r9.iterator();
    L23:
        if (r11.hasNext() == false) goto L30;
        Object r12 = r11.next();
        List<String> r13 = ((f) r12).D.selectKeys;
        if (r13 == null) goto L27;
        boolean r14 = CollectionsKt.contains(r13, r0.a);
    L28:
        if (r14 == false) goto L23;
        r6.add(r12);
        goto L23
    L27:
        r14 = false;
        goto L28
    L30:
        r9 = r6;
    L31:
        List<f> r15 = r9;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r17 = r15.iterator();
    L33:
        if (r17.hasNext() == false) goto L35;
        f r18 = (f) r17.next();
        r18.A = Intrinsics.areEqual(r0.a, "热门");
        r16.add(r18);
        goto L33
    L35:
        r5.setData(r16);
        return;
    L46:
        return;
    L12:
        r4 = null;
        goto L14
    L45:
        return;
    }

    public final int getItemPosition(Object r9) {
        Intrinsics.checkNotNullParameter(r9, "obj");
        if (((k81) ft0.a.getValue()).b() == false) goto L32;
        Object r1 = null;
        if ((r9 instanceof RecyclerView) == true) goto L7;
        r9 = null;
    L7:
        RecyclerView r11 = (RecyclerView) r9;
        if (r11 == null) goto L10;
        RecyclerView.Adapter r12 = r11.getAdapter();
    L12:
        if ((r12 instanceof OpenFeatureTabListAdapter) == true) goto L14;
        r12 = null;
    L14:
        OpenFeatureTabListAdapter r13 = (OpenFeatureTabListAdapter) r12;
        if (r13 == null) goto L39;
        Iterator<T> r0 = this.a.iterator();
    L18:
        if (r0.hasNext() == false) goto L28;
        Object r2 = r0.next();
        long r3 = ((a) r2).a;
        Long r5 = r13.c;
        if (r5 != null) goto L23;
    L25:
        boolean r4 = false;
    L26:
        if (r4 == false) goto L18;
        r1 = r2;
        goto L28
    L23:
        if (r3 != r5.longValue()) goto L25;
        r4 = true;
    L28:
        a r6 = (a) r1;
        if (r6 == null) goto L40;
        r13.setData(i(Long.valueOf(r6.a), r6.b));
        return -1;
    L40:
        return -2;
    L39:
        return -2;
    L10:
        r12 = null;
        goto L12
    L32:
        return -2;
    }

    public final CharSequence getPageTitle(int r2) {
        return ((d) ListProtector.get(this.b, r2)).b;
    }

    public final View c(Context r5, int r6) {
        CharSequence r0 = getPageTitle(r6);
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        Intrinsics.checkNotNull(r5);
        com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab.f r1 = new com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab.f(r5, r0);
        boolean r7 = false;
        if (r6 != 0) goto L8;
        boolean r2 = true;
    L10:
        if (((k81) ft0.a.getValue()).c() == false) goto L17;
        ViewPager r3 = this.g;
        if (r3 != null) goto L14;
    L16:
        r2 = r7;
        goto L17
    L14:
        if (r6 != r3.getCurrentItem()) goto L16;
        r7 = true;
    L17:
        if (r2 == false) goto L19;
        int r8 = 2131107978;
    L20:
        r1.setColor(s1.h(r8));
        r1.setTextSize(15.0f);
        return r1;
    L19:
        r8 = 2131107981;
        goto L20
    L8:
        r2 = false;
        goto L10
    }

    public final void g(List<a> r2, List<d> r3) {
        Intrinsics.checkNotNullParameter(r2, "items");
        Intrinsics.checkNotNullParameter(r3, "tabNameList");
        this.a.clear();
        this.a.addAll(r2);
        this.b.clear();
        this.b.addAll(r3);
        notifyDataSetChanged();
    }

    public final List<f> i(Long r4, List<f> r5) {
        List<f> r6 = r5;
        ArrayList r7 = new ArrayList();
        Iterator<T> r0 = r6.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (((f) r1).u == false) goto L4;
        r7.add(r1);
        goto L4
    L8:
        ArrayList r2 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L10:
        if (r8.hasNext() == false) goto L15;
        Object r3 = r8.next();
        if (((f) r3).u == true) goto L10;
        r2.add(r3);
        goto L10
    L15:
        return CollectionsKt.plus(r7, r2);
    }

    public final Object instantiateItem(ViewGroup r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, KtvSubElement.CONTAINER);
        RecyclerView r0 = LayoutInflater.from(r11.getContext()).inflate(2131567071, r11, false);
        if ((r0 instanceof RecyclerView) == true) goto L5;
        RecyclerView r1 = null;
    L6:
        RecyclerView r2 = r1;
        if (r2 != null) goto L9;
        return r0;
    L9:
        r2.setOverScrollMode(2);
        r2.setLayoutManager(new LinearLayoutManager(r11.getContext()));
        List<f> r3 = ((a) ListProtector.get(this.a, r12)).b;
        ArrayList r4 = new ArrayList();
        e r6 = this.e;
        OpenFeatureIconCallbackFrom r7 = OpenFeatureIconCallbackFrom.TAB_LIST;
        r4.add(new c(r6, r7));
        r4.add(new g20.e(this.e, r7, null));
        n0 r5 = ((d) ListProtector.get(this.b, r12)).c;
        if (r5 != null) goto L12;
    L23:
        r2.setAdapter(new OpenFeatureTabListAdapter(r3, r4, Long.valueOf(((a) ListProtector.get(this.a, r12)).a)));
        RecyclerView.Adapter r8 = r2.getAdapter();
        if (r8 == null) goto L40;
        ((OpenFeatureTabListAdapter) r8).notifyDataSetChanged();
        LivePagerSlidingTabStrip r9 = this.f;
        if (r9 == null) goto L30;
        ViewPager r13 = this.g;
        if (r13 == null) goto L30;
        r9.setViewPager(r13);
    L30:
        Function3<? super RecyclerView, ? super LinearLayoutManager, ? super Integer, Unit> r14 = this.d;
        if (r14 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("rvInitCallback");
    L33:
        LinearLayoutManager r15 = r2.getLayoutManager();
        if (r15 == null) goto L38;
        r14.invoke(r2, r15, Integer.valueOf(r12));
        r11.addView(r2);
        this.c.put(Integer.valueOf(r12), new WeakReference(r2));
        return r2;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    L40:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.OpenFeatureTabListAdapter");
    L12:
        if (TextUtils.isEmpty(r5.a) == true) goto L23;
        ArrayList r16 = new ArrayList();
        Iterator r17 = r3.iterator();
    L15:
        if (r17.hasNext() == false) goto L22;
        Object r18 = r17.next();
        List<String> r19 = ((f) r18).D.selectKeys;
        if (r19 == null) goto L19;
        boolean r21 = CollectionsKt.contains(r19, r5.a);
    L20:
        if (r21 == false) goto L15;
        r16.add(r18);
        goto L15
    L19:
        r21 = false;
        goto L20
    L22:
        r3 = r16;
        goto L23
    L5:
        r1 = r0;
        goto L6
    }

    public final boolean isViewFromObject(View r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        Intrinsics.checkNotNullParameter(r3, "p1");
        return Intrinsics.areEqual(r2, r3);
    }

    public final void destroyItem(ViewGroup r1, int r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r3, "object");
        r1.removeView((View) r3);
    }

    public final void h(List<d> r8, ViewPager r9, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r8, "data");
        List<b20.e> r0 = this.h;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        Iterator<b20.e> r2 = this.h.iterator();
    L13:
        if (r2.hasNext() == false) goto L23;
        b20.e r3 = r2.next();
        Iterator<T> r4 = r8.iterator();
        int r5 = 0;
    L16:
        if (r4.hasNext() == false) goto L13;
        if (r3.a(((d) r4.next()).a, r11) == false) goto L22;
        if (r3.b(r8, r9, r5) == false) goto L22;
        return;
    L22:
        r5 = r5 + 1;
        goto L16
    L23:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public OpenFeatureTabPageAdapterV3(a20.d r1, LivePagerSlidingTabStrip r2, ViewPager r3, List r4) {
        this.e = r1;
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new LinkedHashMap();
    }
}
