package com.bytedance.android.livesdk.gift.platform.format.panel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.live.core.utils.rxutils.j;
import com.bytedance.android.live.revenue.common.i;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.SimpleSweepGiftViewHolder;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.f0;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdk.gift.platform.format.panel.viewmodel.FormatGiftDialogViewModel;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import m02.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/format/panel/adapter/FormatGiftDialogViewPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FormatGiftDialogViewPagerAdapter extends PagerAdapter {
    public static final /* synthetic */ int o = 0;
    public final Map<Integer, Boolean> a;
    public final List<w1> b;
    public final Map<Integer, Integer> c;
    public final Map<Integer, FormatGiftDialogAdapter> d;
    public IntRange e;
    public IntRange f;
    public IntRange g;
    public final Map<Integer, IntRange> h;
    public long i;
    public final int j;
    public Disposable k;
    public boolean l;
    public final Map<Integer, Long> m;
    public final GiftViewModelManager n;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ FormatGiftDialogViewPagerAdapter a;
        public final /* synthetic */ RecyclerView b;
        public final /* synthetic */ int c;
        public final /* synthetic */ boolean d;

        public b(FormatGiftDialogViewPagerAdapter r1, RecyclerView r2, int r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            Disposable r6 = this.a.k;
            if (r6 == null) goto L5;
            r6.dispose();
        L5:
            this.a.j(this.b, this.c, this.d);
            this.a.k(this.b, this.c);
        }
    }

    static {
    }

    public final int getCount() {
        return ((ArrayList) this.b).size();
    }

    public final void g(RecyclerView r13) {
        long r8 = System.currentTimeMillis();
        if (r13 != null) goto L5;
        return;
    L5:
        Object r10 = r13.getTag();
        Iterator r11 = ((LinkedHashMap) this.m).entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L13;
        Map.Entry r0 = (Map.Entry) r11.next();
        if (r10 == null) goto L12;
        i(r13, ((Integer) r10).intValue(), ((Number) r0.getKey()).intValue(), ((Number) r0.getValue()).longValue(), r8);
        goto L7
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L13:
        ((LinkedHashMap) this.m).clear();
    }

    public final int getItemPosition(Object r6) {
        Intrinsics.checkNotNullParameter(r6, "obj");
        if ((r6 instanceof RecyclerView) == false) goto L21;
        List<w1> r0 = this.b;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r1.add(Integer.valueOf(((w1) r2.next()).getPageType()));
        goto L6
    L8:
        RecyclerView r7 = (RecyclerView) r6;
        if (CollectionsKt.contains(r1, r7.getTag()) == true) goto L12;
        return -2;
    L12:
        int r3 = this.b.size();
        int r4 = 0;
    L13:
        if (r4 >= r3) goto L28;
        int r5 = ((w1) ListProtector.get(this.b, r4)).getPageType();
        Object r8 = r7.getTag();
        if ((r8 instanceof Integer) == false) goto L20;
        if (r5 != ((Integer) r8).intValue()) goto L20;
        return r4;
    L20:
        r4 = r4 + 1;
        goto L13
    L28:
        return -1;
    L21:
        return -1;
    }

    public final void h(RecyclerView r7) {
        RecyclerView.LayoutManager r0 = null;
        if (r7 == null) goto L5;
        RecyclerView.LayoutManager r1 = r7.getLayoutManager();
    L7:
        if ((r1 instanceof LinearLayoutManager) == false) goto L10;
        r0 = r1;
    L10:
        LinearLayoutManager r2 = (LinearLayoutManager) r0;
        if (r2 == null) goto L16;
        long r3 = System.currentTimeMillis();
        IntIterator r8 = new IntRange(e.a(r2, r7, 66, false), e.c(r2, r7, 66, false)).iterator();
    L14:
        if (r8.hasNext() == false) goto L18;
        this.m.put(Integer.valueOf(r8.nextInt()), Long.valueOf(r3));
        goto L14
    L18:
        return;
    L16:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public FormatGiftDialogViewPagerAdapter(GiftViewModelManager r1, FormatGiftDialogViewModel r2) {
        Intrinsics.checkNotNullParameter(r1, "viewModel");
        this.n = r1;
        this.a = new LinkedHashMap();
        this.b = new ArrayList();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new IntRange(-1, -1);
        this.f = new IntRange(-1, -1);
        this.g = new IntRange(-1, -1);
        this.h = new LinkedHashMap();
        this.j = 50;
        this.m = new LinkedHashMap();
    }

    public final void f(Context r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Map<Integer, Boolean> r1 = this.a;
        LinkedHashMap r2 = (LinkedHashMap) r1;
        Boolean r3 = (Boolean) r2.get(Integer.valueOf(r6));
        Boolean r4 = Boolean.TRUE;
        if (Intrinsics.areEqual(r3, r4) == false) goto L5;
        return;
    L5:
        this.a.put(Integer.valueOf(r6), r4);
        Intrinsics.checkNotNullParameter(r5, "context");
        if (this.d.containsKey(Integer.valueOf(r6)) == true) goto L8;
        this.d.put(Integer.valueOf(r6), new FormatGiftDialogAdapter(r5, this.n));
    L8:
        Map<Integer, FormatGiftDialogAdapter> r7 = this.d;
        LinkedHashMap r8 = (LinkedHashMap) r7;
        FormatGiftDialogAdapter r9 = (FormatGiftDialogAdapter) r8.get(Integer.valueOf(r6));
        if (r9 == null) goto L11;
        r9.y2(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.l(r6));
    L11:
        notifyDataSetChanged();
    }

    public final Object instantiateItem(ViewGroup r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "container");
        Context r0 = r8.getContext();
        int r10 = ((w1) ListProtector.get(this.b, r9)).getPageType();
        Map<Integer, FormatGiftDialogAdapter> r1 = this.d;
        LinkedHashMap r2 = (LinkedHashMap) r1;
        FormatGiftDialogAdapter r3 = (FormatGiftDialogAdapter) r2.get(Integer.valueOf(r10));
        if (r3 != null) goto L5;
        r3 = new FormatGiftDialogAdapter(r0, this.n);
    L5:
        this.d.put(Integer.valueOf(r10), r3);
        com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.l(r10);
        Map<Integer, FormatGiftDialogAdapter> r4 = this.d;
        LinkedHashMap r5 = (LinkedHashMap) r4;
        FormatGiftDialogAdapter r6 = (FormatGiftDialogAdapter) r5.get(Integer.valueOf(r10));
        if (r6 == null) goto L9;
        r6.notifyDataSetChanged();
    L9:
        Context r7 = r8.getContext();
        View r11 = LayoutInflater.from(r7).inflate(2131567915, null);
        if (r11 == null) goto L34;
        RecyclerView r13 = (RecyclerView) r11;
        r13.getRecycledViewPool().setMaxRecycledViews(1, 12);
        r13.setAdapter(r3);
        r13.setItemAnimator(null);
        r13.setLayoutManager(new SSGridLayoutManager(r7, 4, 1));
        r13.setClipChildren(false);
        r13.setClipToPadding(false);
        r13.addOnScrollListener(new FormatGiftDialogViewPagerAdapter$createRecyclerView$$inlined$apply$lambda$1(r13, this, r10));
        r13.setTag(Integer.valueOf(r10));
        LinearLayoutManager r14 = r13.getLayoutManager();
        Map<Integer, Integer> r15 = this.c;
        LinkedHashMap r16 = (LinkedHashMap) r15;
        Integer r17 = (Integer) r16.get(Integer.valueOf(r10));
        if (r17 == null) goto L14;
        int r18 = r17.intValue();
    L16:
        if ((r14 instanceof LinearLayoutManager) == false) goto L30;
        LinearLayoutManager r19 = r14;
        int r20 = r19.findFirstCompletelyVisibleItemPosition();
        int r21 = r19.findLastCompletelyVisibleItemPosition();
        if (r20 > r18) goto L21;
        if (r21 >= r18) goto L30;
    L21:
        if (this.n.getIsVertical() == false) goto L23;
    L28:
        r19.scrollToPositionWithOffset(r18, i.b(1));
    L29:
        l(r13, r10, false, true);
    L31:
        r8.addView(r13);
        return r13;
    L23:
        if (PadConfigUtils.c() == true) goto L28;
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L28;
        r19.scrollToPositionWithOffset(r18, i.b(2));
    L30:
        r13.scrollToPosition(r18);
        goto L31
    L14:
        r18 = 0;
        goto L16
    L34:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
    }

    public final boolean isViewFromObject(View r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "k");
        Intrinsics.checkNotNullParameter(r3, "v");
        return Intrinsics.areEqual(r2, r3);
    }

    public final void k(RecyclerView r18, int r19) {
        RecyclerView.LayoutManager r0 = null;
        if (r18 == null) goto L5;
        RecyclerView.LayoutManager r1 = r18.getLayoutManager();
    L7:
        if ((r1 instanceof LinearLayoutManager) == false) goto L10;
        r0 = r1;
    L10:
        LinearLayoutManager r10 = (LinearLayoutManager) r0;
        if (r10 == null) goto L26;
        long r11 = System.currentTimeMillis();
        int r14 = e.a(r10, r18, 50, false);
        int r15 = e.c(r10, r18, 50, false);
        LinkedHashMap r6 = new LinkedHashMap();
        Iterator r16 = ((LinkedHashMap) this.m).entrySet().iterator();
    L14:
        if (r16.hasNext() == false) goto L20;
        Map.Entry r2 = (Map.Entry) r16.next();
        int r3 = ((Number) r2.getKey()).intValue();
        long r4 = ((Number) r2.getValue()).longValue();
        if (new IntRange(r14, r15).contains(r3) == true) goto L18;
        LinkedHashMap r13 = r6;
        i(r18, r19, r3, r4, r11);
    L19:
        r6 = r13;
        goto L14
    L18:
        r13 = r6;
        r13.put(Integer.valueOf(r3), Long.valueOf(r4));
        goto L19
    L20:
        ((LinkedHashMap) this.m).clear();
        this.m.putAll(r6);
        IntIterator r5 = new IntRange(e.a(r10, r18, 66, false), e.c(r10, r18, 66, false)).iterator();
    L22:
        if (r5.hasNext() == false) goto L35;
        int r7 = r5.nextInt();
        if (this.m.containsKey(Integer.valueOf(r7)) == true) goto L22;
        this.m.put(Integer.valueOf(r7), Long.valueOf(r11));
        goto L22
    L35:
        return;
    L26:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void m(int r4, int r5) {
        if (Intrinsics.areEqual(new IntRange(r4, r5), new IntRange(0, 0)) == false) goto L5;
        IntRange r0 = new IntRange(0, 0);
    L7:
        if ((!Intrinsics.areEqual(r0, this.g)) == false) goto L13;
        GiftContext r1 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r1 == null) goto L13;
        m<f0> r2 = r1.getRowLocation();
        if (r2 == null) goto L13;
        r2.setValue(new f0((r4 / 4) + 1, (r5 / 4) + 1));
    L13:
        this.g = r0;
        return;
    L5:
        r0 = new IntRange((r4 / 4) + 1, (r5 / 4) + 1);
        goto L7
    }

    public final void destroyItem(ViewGroup r3, int r4, Object r5) {
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r5, "obj");
        if ((r5 instanceof RecyclerView) == false) goto L16;
        RecyclerView r6 = (RecyclerView) r5;
        RecyclerView.LayoutManager r0 = r6.getLayoutManager();
        if ((r0 instanceof GridLayoutManager) == true) goto L7;
        r0 = null;
    L7:
        GridLayoutManager r1 = (GridLayoutManager) r0;
        if (r1 == null) goto L14;
        int r2 = r1.findFirstVisibleItemPosition();
        Object r7 = r6.getTag();
        if (r7 == null) goto L13;
        int r8 = ((Integer) r7).intValue();
        this.c.put(Integer.valueOf(r8), Integer.valueOf(r2));
        goto L14
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L14:
        r3.removeView((View) r5);
        return;
    }

    public final void j(final RecyclerView r9, final int r10, final boolean r11) {
        RecyclerView.LayoutManager r0 = r9.getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == true) goto L5;
        r0 = null;
    L5:
        LinearLayoutManager r1 = (LinearLayoutManager) r0;
        if (r1 == null) goto L40;
        int r2 = this.e.getFirst();
        int r3 = this.e.getLast();
        int r4 = e.a(r1, r9, this.j, false);
        int r5 = e.c(r1, r9, this.j, false);
        if (r2 == (-1)) goto L10;
        if (r2 > r4) goto L10;
    L11:
        if (r3 == (-1)) goto L13;
        if (r3 < r5) goto L13;
    L14:
        this.e = new IntRange(r2, r3);
        IntRange r6 = this.f;
        IntRange r7 = new IntRange(r4, r5);
        Function2<Integer, AbsPanel<?>, Unit> r8 = new FormatGiftDialogViewPagerAdapter$logScroll$$inlined$let$lambda$1(this, r9, r10, r11);
        int r13 = r7.getFirst();
        int r14 = r7.getLast();
        if (r13 > r14) goto L31;
    L16:
        if (r13 == (-1)) goto L31;
        if (r6.contains(r13) == true) goto L29;
        Map<Integer, FormatGiftDialogAdapter> r15 = this.d;
        LinkedHashMap r16 = (LinkedHashMap) r15;
        FormatGiftDialogAdapter r17 = (FormatGiftDialogAdapter) r16.get(Integer.valueOf(r10));
        if (r17 == null) goto L31;
        List<AbsPanel<?>> r18 = r17.a;
        if (r18 == null) goto L31;
        AbsPanel r19 = (AbsPanel) CollectionsKt.getOrNull(r18, r13);
        if (r19 == null) goto L31;
        r8.invoke(Integer.valueOf(r13), r19);
    L29:
        if (r13 == r14) goto L31;
        r13 = r13 + 1;
    L31:
        this.f = new IntRange(r4, r5);
        this.h.put(Integer.valueOf(r10), new IntRange(r4, r5));
        if (r11 == false) goto L41;
        m(r4, r5);
        return;
    L41:
        return;
    L13:
        r3 = r5;
    L10:
        r2 = r4;
        goto L11
    }

    public final void l(RecyclerView r3, int r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        AbsPanel<?> r0 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.b();
        if (r0 == null) goto L6;
        GiftStateMachineConfig.Event.g r1 = new GiftStateMachineConfig.Event.g(r0);
        r1.a = false;
        com.bytedance.android.livesdk.gift.util.b.f(r1);
    L6:
        if (this.l == true) goto L9;
        if (r6 == true) goto L9;
        this.l = true;
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.g0());
    L9:
        if (r5 == false) goto L11;
        this.f = new IntRange(-1, -1);
        this.e = new IntRange(-1, -1);
        j.a r7 = j.a;
        this.k = j.c(200, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r3, r4, r5));
        return;
    L11:
        j(r3, r4, r5);
        k(r3, r4);
    }

    public final void i(RecyclerView r13, int r14, int r15, long r16, long r17) {
        FormatGiftDialogAdapter r1 = (FormatGiftDialogAdapter) ((LinkedHashMap) this.d).get(Integer.valueOf(r14));
        if (r1 == null) goto L24;
        List<AbsPanel<?>> r2 = r1.a;
        if (r2 == null) goto L25;
        AbsPanel r3 = (AbsPanel) CollectionsKt.getOrNull(r2, r15);
        if (r3 != null) goto L10;
        return;
    L10:
        RecyclerView.ViewHolder r4 = null;
        if (r13 == null) goto L13;
        RecyclerView.ViewHolder r0 = r13.findViewHolderForAdapterPosition(r15);
    L15:
        if ((r0 instanceof SimpleSweepGiftViewHolder) == false) goto L18;
        r4 = r0;
    L18:
        SimpleSweepGiftViewHolder r5 = (SimpleSweepGiftViewHolder) r4;
        if (r5 == null) goto L21;
        boolean r6 = r5.Y3();
    L22:
        h.H(r3.c(), r3.h instanceof h1, r14, r15, r6, r16, r17);
        return;
    L21:
        r6 = false;
        goto L22
    L13:
        r0 = null;
        goto L15
    L25:
        return;
    }
}
