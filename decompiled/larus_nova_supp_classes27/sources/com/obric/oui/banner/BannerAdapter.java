package com.obric.oui.banner;

import android.view.ViewGroup;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/obric/oui/banner/BannerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/oui/banner/BannerViewHolder;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class BannerAdapter extends RecyclerView.Adapter<BannerViewHolder> {
    public final kla.a a;
    public final Map<String, e> b;
    public final List<e> c;
    public kla.b d;
    public final WeakHashMap<BannerViewHolder, Unit> e;
    public List<? extends b> f;
    public boolean g;

    public final int getItemCount() {
        if (this.g == false) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return this.f.size();
    }

    public BannerAdapter(OBanner r4) {
        Intrinsics.checkNotNullParameter(r4, "bannerOperator");
        this.a = r4;
        LinkedHashMap r5 = new LinkedHashMap();
        this.b = r5;
        ArrayList r0 = new ArrayList();
        this.c = r0;
        this.e = new WeakHashMap();
        this.f = CollectionsKt.emptyList();
        this.g = true;
        StubViewHolder.a r1 = StubViewHolder.g;
        Intrinsics.checkNotNullParameter(r1, "factory");
        r5.put("_stub", r1);
        r0.add(r1);
    }

    public final int getItemViewType(int r3) {
        if (((ArrayList) this.c).isEmpty() == true) goto L11;
        if (this.f.isEmpty() == false) goto L7;
        StubViewHolder.a r4 = StubViewHolder.g;
    L8:
        e r5 = (e) ((LinkedHashMap) this.b).get("_stub");
        return CollectionsKt.indexOf(this.c, r5);
    L7:
        List<? extends b> r0 = this.f;
        ((b) ListProtector.get(r0, r3 % r0.size())).a();
        goto L8
    L11:
        throw new IllegalStateException("Register your BannerViewHolder into the Banner ~ ");
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r3) {
        BannerViewHolder r4 = (BannerViewHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        super.onViewAttachedToWindow(r4);
        kla.a r0 = r4.b;
        if (r0 == null) goto L9;
        LiveData<Integer> r1 = r0.getSelectedPosition();
        if (r1 == null) goto L9;
        r1.observeForever(r4.e);
    L9:
        this.e.put(r4, Unit.INSTANCE);
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r4) {
        BannerViewHolder r5 = (BannerViewHolder) r4;
        Intrinsics.checkNotNullParameter(r5, "holder");
        super.onViewDetachedFromWindow(r5);
        kla.a r0 = r5.b;
        if (r0 == null) goto L9;
        LiveData<Integer> r1 = r0.getSelectedPosition();
        if (r1 == null) goto L9;
        r1.removeObserver(r5.e);
    L9:
        CoroutineScope r2 = r5.d;
        if (r2 == null) goto L12;
        CoroutineScopeKt.cancel$default(r2, null, 1, null);
    L12:
        r5.a = false;
        this.e.remove(r5);
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        BannerViewHolder r3 = (BannerViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewRecycled(r3);
        r3.getClass();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        BannerViewHolder r7 = (BannerViewHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        int r0 = lla.a.a;
        boolean r1 = this.g;
        int r2 = this.f.size();
        if (r1 == false) goto L10;
        if (r2 > 0) goto L8;
        r2 = 1;
    L8:
        r6 = r6 % r2;
    L10:
        if (this.f.isEmpty() == false) goto L12;
        g r3 = new g();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r3, "data");
        r7.c = r6;
        r7.U3(r3);
        r7.T3(true);
        return;
    L12:
        b r4 = (b) ListProtector.get(this.f, r6);
        if ((r4 instanceof d) == false) goto L15;
        ((d) r4).b();
    L15:
        r7.getClass();
        Intrinsics.checkNotNullParameter(r4, "data");
        r7.c = r6;
        r7.U3(r4);
        r7.T3(true);
        ((RecyclerView.ViewHolder) r7).itemView.setTag(2131363947, Integer.valueOf(r6));
        if (((RecyclerView.ViewHolder) r7).itemView.hasOnClickListeners() == true) goto L20;
        ((RecyclerView.ViewHolder) r7).itemView.setOnClickListener(new a(this));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        if (((ArrayList) this.c).isEmpty() == true) goto L7;
        StubViewHolder r4 = ((e) ListProtector.get(this.c, r3)).a(r2);
        r4.b = this.a;
        return r4;
    L7:
        throw new IllegalStateException("Register your BannerViewHolder into the Banner ~ ");
    }
}
