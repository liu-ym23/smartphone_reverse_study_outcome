package com.obric.oui.banner;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.common.oui.R$id;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/obric/oui/banner/BannerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/oui/banner/BannerViewHolder;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BannerAdapter extends RecyclerView.Adapter<BannerViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wq.a f11999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f12000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f12001c;
    public android.support.v4.media.c d;
    public final WeakHashMap e;
    public List f;
    public boolean g;

    public BannerAdapter(wq.a r5) {
        Intrinsics.checkNotNullParameter(r5, "bannerOperator");
        this.f11999a = r5;
        LinkedHashMap r10 = new LinkedHashMap();
        this.f12000b = r10;
        ArrayList r11 = new ArrayList();
        this.f12001c = r11;
        this.e = new WeakHashMap();
        this.f = CollectionsKt.emptyList();
        this.g = true;
        e r12 = StubViewHolder.g;
        Intrinsics.checkNotNullParameter(r12, "factory");
        r10.put("_stub", r12);
        r11.add(r12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (this.g == false) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return this.f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r5) {
        ArrayList r10 = this.f12001c;
        if (r10.isEmpty() == true) goto L11;
        if (this.f.isEmpty() == false) goto L7;
        e r11 = StubViewHolder.g;
    L9:
        return CollectionsKt.o(r10, (e) this.f12000b.get("_stub"));
    L7:
        List r12 = this.f;
        ((d) r12.get(r5 % r12.size())).getClass();
        e r13 = StubViewHolder.g;
        goto L9
    L11:
        throw new IllegalStateException("Register your BannerViewHolder into the Banner ~ ");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r10) {
        BannerViewHolder r11 = (BannerViewHolder) r5;
        Intrinsics.checkNotNullParameter(r11, "holder");
        boolean r12 = this.g;
        int r13 = this.f.size();
        if (r12 == false) goto L10;
        if (r13 > 0) goto L8;
        r13 = 1;
    L8:
        r10 = r10 % r13;
    L10:
        if (this.f.isEmpty() == false) goto L12;
        d r14 = new d();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r14, "data");
        r11.f12005c = r10;
        r11.b(r14);
        r11.a(true);
        return;
    L12:
        d r15 = (d) this.f.get(r10);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r15, "data");
        r11.f12005c = r10;
        r11.b(r15);
        r11.a(true);
        r11.itemView.setTag(R$id.banner_pos_key, Integer.valueOf(r10));
        if (r11.itemView.hasOnClickListeners() == true) goto L17;
        r11.itemView.setOnClickListener(new ar.a(this, 15));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        ArrayList r11 = this.f12001c;
        if (r11.isEmpty() == true) goto L7;
        ((e) r11.get(r10)).getClass();
        Intrinsics.checkNotNullParameter(r5, "parent");
        View r12 = new View(r5.getContext());
        r12.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Intrinsics.checkNotNullParameter(r12, "view");
        StubViewHolder r13 = new StubViewHolder(r12);
        r13.f12004b = this.f11999a;
        return r13;
    L7:
        throw new IllegalStateException("Register your BannerViewHolder into the Banner ~ ");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r5) {
        BannerViewHolder r10 = (BannerViewHolder) r5;
        Intrinsics.checkNotNullParameter(r10, "holder");
        super.onViewAttachedToWindow(r10);
        wq.a r11 = r10.f12004b;
        if (r11 == null) goto L9;
        LiveData r12 = r11.getSelectedPosition();
        if (r12 == null) goto L9;
        r12.observeForever(r10.e);
    L9:
        this.e.put(r10, Unit.INSTANCE);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r5) {
        BannerViewHolder r10 = (BannerViewHolder) r5;
        Intrinsics.checkNotNullParameter(r10, "holder");
        super.onViewDetachedFromWindow(r10);
        wq.a r11 = r10.f12004b;
        if (r11 == null) goto L9;
        LiveData r12 = r11.getSelectedPosition();
        if (r12 == null) goto L9;
        r12.removeObserver(r10.e);
    L9:
        kotlinx.coroutines.internal.c r13 = r10.d;
        if (r13 == null) goto L12;
        h0.c(r13, null);
    L12:
        r10.f12003a = false;
        this.e.remove(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r5) {
        BannerViewHolder r10 = (BannerViewHolder) r5;
        Intrinsics.checkNotNullParameter(r10, "holder");
        super.onViewRecycled(r10);
        r10.getClass();
    }
}
