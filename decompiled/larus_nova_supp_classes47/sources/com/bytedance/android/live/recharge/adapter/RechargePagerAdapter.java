package com.bytedance.android.live.recharge.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.live.recharge.RechargeDialogFragmentV2;
import com.bytedance.android.live.recharge.deal.f;
import com.bytedance.android.live.recharge.panel.d;
import com.bytedance.android.live.recharge.platform.business.viewholder.AbsRechargeViewHolder;
import com.bytedance.android.live.recharge.platform.business.viewholder.RechargeItem;
import com.bytedance.android.live.recharge.utils.j;
import com.bytedance.android.live.recharge.viewholder.CustomDealViewHolder;
import com.bytedance.android.live.recharge.viewholder.DealViewHolder;
import com.bytedance.android.live.revenue.common.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/recharge/adapter/RechargePagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "b", "RechargeItemAdapter", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargePagerAdapter extends PagerAdapter {
    public static final int h = 0;
    public List<? extends List<? extends RechargeItem>> a;
    public RechargeItem.CustomItem b;
    public long c;
    public AbsRechargeViewHolder<?> d;
    public final RechargeDialogContext e;
    public final ViewPager f;
    public final ax0.a g;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/adapter/RechargePagerAdapter$RechargeItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/recharge/platform/business/viewholder/AbsRechargeViewHolder;", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class RechargeItemAdapter extends RecyclerView.Adapter<AbsRechargeViewHolder<?>> {
        public final int a;
        public final /* synthetic */ RechargePagerAdapter b;

        public final int getItemCount() {
            return ((List) ListProtector.get(this.b.a, this.a)).size();
        }

        public final int getItemViewType(int r3) {
            RechargeItem r4 = (RechargeItem) ListProtector.get((List) ListProtector.get(this.b.a, this.a), r3);
            if ((r4 instanceof RechargeItem.CustomItem) == false) goto L6;
            return 1;
        L6:
            if ((r4 instanceof RechargeItem.a) == false) goto L10;
            return 0;
        L10:
            throw new NoWhenBranchMatchedException();
        }

        public RechargeItemAdapter(RechargePagerAdapter r1, int r2) {
            this.b = r1;
            this.a = r2;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
            AbsRechargeViewHolder r12 = (AbsRechargeViewHolder) r9;
            Intrinsics.checkNotNullParameter(r12, "viewHolder");
            Object r0 = ListProtector.get((List) ListProtector.get(this.b.a, this.a), r10);
            if (r0 == null) goto L17;
            RechargeItem r1 = (RechargeItem) r0;
            r12.T3(r1);
            if ((r1 instanceof RechargeItem.a) == false) goto L10;
            long r3 = ((RechargeItem.a) r1).a.b();
            RechargePagerAdapter r2 = this.b;
            if (r3 != r2.c) goto L10;
            RechargePagerAdapter.f(r2, r12, true, r10);
        L14:
            ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(new com.bytedance.android.live.recharge.adapter.a(this, r1, r12, r10));
            return;
        L10:
            if ((r1 instanceof RechargeItem.CustomItem) == false) goto L14;
            if (((RechargeItem.CustomItem) r1).d != RechargeItem.CustomItem.Mode.DIAMOND) goto L14;
            RechargePagerAdapter.f(this.b, r12, true, r10);
            goto L14
        L17:
            throw new NullPointerException("null cannot be cast to non-null type T");
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            if (r5 == 1) goto L6;
            return new DealViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131566379, r4, false));
        L6:
            return new CustomDealViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131566380, r4, false));
        }
    }

    public static final class a<T> implements Consumer {
        public final /* synthetic */ RechargePagerAdapter a;

        public a(RechargePagerAdapter r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Unit r8 = (Unit) r7;
            if (d.c == false) goto L26;
            RechargePagerAdapter r9 = this.a;
            long r0 = ((Number) r9.e.getCustomPrice().a).longValue();
            RechargeItem.CustomItem r2 = r9.b;
            if (r2 != null) goto L8;
            return;
        L8:
            if (r0 == 0) goto L10;
            r2.a = r0;
            r2.c = "自定义";
            r2.d = RechargeItem.CustomItem.Mode.DIAMOND;
        L11:
            AbsRechargeViewHolder<?> r1 = r9.d;
            if (r1 == null) goto L14;
            Object r3 = r1.a;
        L16:
            if ((r3 instanceof RechargeItem.a) == true) goto L18;
            r3 = null;
        L18:
            RechargeItem.a r4 = (RechargeItem.a) r3;
            if (r4 == null) goto L23;
            f r5 = r4.a;
            if (r5 == null) goto L23;
            long r6 = r5.b();
        L24:
            r9.c = r6;
            r9.d = null;
            r9.notifyDataSetChanged();
            return;
        L23:
            r6 = r9.c;
            goto L24
        L14:
            r3 = null;
            goto L16
        L10:
            r2.a = 0;
            r2.c = "";
            r2.d = RechargeItem.CustomItem.Mode.INPUT;
            goto L11
        }
    }

    public static final class b {
    }

    public final int getItemPosition(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "obj");
        return -2;
    }

    static {
        h = i.b(12);
    }

    public final int getCount() {
        return this.a.size();
    }

    public final Object instantiateItem(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "container");
        RecyclerView r0 = new RecyclerView(r5.getContext());
        r0.setLayoutManager(new GridLayoutManager(r5.getContext(), 3));
        int r1 = h;
        r0.setPadding(r1, 0, r1, 0);
        r0.setAdapter(new RechargeItemAdapter(this, r6));
        r0.setOverScrollMode(2);
        r0.setTag(Integer.valueOf(r6));
        r5.addView(r0, new ViewGroup.LayoutParams(-1, -1));
        return r0;
    }

    public final boolean isViewFromObject(View r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "o");
        return Intrinsics.areEqual(r2, r3);
    }

    public RechargePagerAdapter(RechargeDialogContext r2, ViewPager r3, ax0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "dialogContext");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.a = CollectionsKt.emptyList();
        if (r3 == null) goto L5;
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
    L7:
        if (j.d().getPanelHeightAdjust() == false) goto L10;
        if (r5 == null) goto L10;
        r5.height = RechargeDialogFragmentV2.n * 2;
    L10:
        RxUtilKt.c(RxUtilKt.h(r2.getCustomRechargePageHideEvent()).subscribe(new a(this)), r2.getCd());
        return;
    L5:
        r5 = null;
        goto L7
    }

    public final void destroyItem(ViewGroup r1, int r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "container");
        Intrinsics.checkNotNullParameter(r3, "obj");
        r1.removeView((View) r3);
    }

    public static final void f(RechargePagerAdapter r3, AbsRechargeViewHolder r4, boolean r5, int r6) {
        AbsRechargeViewHolder<?> r0 = r3.d;
        if (r0 == null) goto L5;
        r0.V3();
    L5:
        AbsRechargeViewHolder<?> r1 = r3.d;
        if (r1 == null) goto L8;
        Object r2 = r1.a;
    L10:
        if ((r2 instanceof RechargeItem.CustomItem) == false) goto L12;
        r3.e.getCustomPrice().a(0L);
    L12:
        r4.U3();
        r3.d = r4;
        RechargeItem r7 = r4.a;
        if (r7 == null) goto L16;
        r3.g.bc(r7, r5, r6);
        return;
    L16:
        return;
    L8:
        r2 = null;
        goto L10
    }
}
