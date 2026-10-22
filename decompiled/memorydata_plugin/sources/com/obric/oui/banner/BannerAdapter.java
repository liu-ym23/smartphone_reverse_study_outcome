package com.obric.oui.banner;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0016J\u0006\u0010)\u001a\u00020&J\u0018\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010(\u001a\u00020&H\u0016J\u0018\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020&H\u0016J\u0010\u00100\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0002H\u0016J\u0010\u00101\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0002H\u0016J\u0010\u00102\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0002H\u0016J\u000e\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020!J\u0006\u00105\u001a\u00020\bJ\u000e\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\u0016J\u000e\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR0\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020!0#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/obric/oui/banner/BannerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/oui/banner/BannerViewHolder;", "bannerOperator", "Lcom/obric/oui/banner/interfaces/BannerOperator;", "(Lcom/obric/oui/banner/interfaces/BannerOperator;)V", "createdHolders", "Ljava/util/WeakHashMap;", "", "getCreatedHolders", "()Ljava/util/WeakHashMap;", "setCreatedHolders", "(Ljava/util/WeakHashMap;)V", EventBody.KEY_VALUE, "", "Lcom/obric/oui/banner/BannerData;", "dataSet", "getDataSet", "()Ljava/util/List;", "setDataSet", "(Ljava/util/List;)V", "mBannerGridConfig", "Lcom/obric/oui/banner/configs/IBannerConfig;", "mBannerItemClickListener", "Lcom/obric/oui/banner/interfaces/OnBannerItemClickListener;", "useInfiniteItemCount", "", "getUseInfiniteItemCount", "()Z", "setUseInfiniteItemCount", "(Z)V", "viewHolderFactoryList", "", "Lcom/obric/oui/banner/IBannerViewHolderFactory;", "viewHolderFactoryMap", "", "", "getItemCount", "", "getItemViewType", "position", "getRealItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewRecycled", "registerViewHolder", "factory", "release", "setBannerConfig", "config", "setBannerItemClickListener", "onBannerClickListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BannerAdapter extends RecyclerView.Adapter<BannerViewHolder> {
    private final com.obric.oui.banner.b.a bannerOperator;
    private WeakHashMap<BannerViewHolder, Unit> createdHolders;
    private List<? extends a> dataSet;
    private com.obric.oui.banner.a.a mBannerGridConfig;
    private com.obric.oui.banner.b.b mBannerItemClickListener;
    private boolean useInfiniteItemCount;
    private final List<c> viewHolderFactoryList;
    private final Map<String, c> viewHolderFactoryMap;

    public BannerAdapter(com.obric.oui.banner.b.a r3) {
        com.obric.oui.banner.b.a r4 = (com.obric.oui.banner.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.banner.b.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "bannerOperator");
        this.bannerOperator = r4;
        this.viewHolderFactoryMap = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.viewHolderFactoryList = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.createdHolders = new WeakHashMap();
        this.dataSet = CollectionsKt.emptyList();
        this.useInfiniteItemCount = true;
        registerViewHolder((c) ZeusTransformUtils.preCheckCast(StubViewHolder.Companion, c.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: lambda$c2Ty1ObBhdkdXjdPHT2GJ-wX_zw, reason: not valid java name */
    public static /* synthetic */ void m1254lambda$c2Ty1ObBhdkdXjdPHT2GJwX_zw(BannerAdapter r0, View r1) {
        m1255onBindViewHolder$lambda0(r0, r1);
    }

    /* JADX INFO: renamed from: onBindViewHolder$lambda-0, reason: not valid java name */
    private static final void m1255onBindViewHolder$lambda0(BannerAdapter r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Object r5 = r4.getTag(ZeusTransformUtils.mapRes(R.id.banner_pos_key, OaidModel.KEY_ID, "banner_pos_key"));
        Objects.requireNonNull(r5, "null cannot be cast to non-null type kotlin.Int");
        int r6 = ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.memorydata.plugin")).intValue();
        com.obric.oui.banner.b.b r0 = r3.mBannerItemClickListener;
        if (r0 == null) goto L7;
        r0.a((a) ZeusTransformUtils.preCheckCast(r3.dataSet.get(r6), a.class, "com.obric.memorydata.plugin"), r6);
        return;
    }

    public final WeakHashMap<BannerViewHolder, Unit> getCreatedHolders() {
        return this.createdHolders;
    }

    public final List<a> getDataSet() {
        return this.dataSet;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.useInfiniteItemCount == false) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return this.dataSet.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r4) {
        if (this.viewHolderFactoryList.isEmpty() == true) goto L11;
        if (this.dataSet.isEmpty() == false) goto L7;
        String r5 = StubViewHolder.Companion.a();
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(this.viewHolderFactoryMap.get(r5), c.class, "com.obric.memorydata.plugin");
        return CollectionsKt.indexOf(this.viewHolderFactoryList, r6);
    L7:
        List<? extends a> r0 = this.dataSet;
        r5 = ((a) ZeusTransformUtils.preCheckCast(r0.get(r4 % r0.size()), a.class, "com.obric.memorydata.plugin")).d();
        goto L8
    L11:
        throw new IllegalStateException("Register your BannerViewHolder into the Banner ~ ");
    }

    public final int getRealItemCount() {
        return this.dataSet.size();
    }

    public final boolean getUseInfiniteItemCount() {
        return this.useInfiniteItemCount;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        onBindViewHolder((BannerViewHolder) ZeusTransformUtils.preCheckCast(r3, BannerViewHolder.class, "com.obric.memorydata.plugin"), r4);
    }

    public void onBindViewHolder(BannerViewHolder r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        int r7 = com.obric.oui.banner.c.a.f13339a.a(this.useInfiniteItemCount, r6, getRealItemCount());
        if (this.dataSet.isEmpty() == false) goto L6;
        r5.onBind(r7, (a) ZeusTransformUtils.preCheckCast(new d(), a.class, "com.obric.memorydata.plugin"));
        return;
    L6:
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.dataSet.get(r7), a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L9;
        ((b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin")).a(this.mBannerGridConfig);
    L9:
        r5.onBind(r7, r0);
        r5.itemView.setTag(ZeusTransformUtils.mapRes(R.id.banner_pos_key, OaidModel.KEY_ID, "banner_pos_key"), Integer.valueOf(r7));
        if (r5.itemView.hasOnClickListeners() == true) goto L13;
        r5.itemView.setOnClickListener(new $$Lambda$BannerAdapter$c2Ty1ObBhdkdXjdPHT2GJwX_zw(this));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return (RecyclerView.ViewHolder) ZeusTransformUtils.preCheckCast(onCreateViewHolder(r1, r2), RecyclerView.ViewHolder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BannerViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (this.viewHolderFactoryList.isEmpty() == true) goto L7;
        BannerViewHolder r5 = ((c) ZeusTransformUtils.preCheckCast(this.viewHolderFactoryList.get(r4), c.class, "com.obric.memorydata.plugin")).a(r3);
        r5.setBannerOperator(this.bannerOperator);
        return r5;
    L7:
        throw new IllegalStateException("Register your BannerViewHolder into the Banner ~ ");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder r3) {
        onViewAttachedToWindow((BannerViewHolder) ZeusTransformUtils.preCheckCast(r3, BannerViewHolder.class, "com.obric.memorydata.plugin"));
    }

    public void onViewAttachedToWindow(BannerViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewAttachedToWindow((RecyclerView.ViewHolder) ZeusTransformUtils.preCheckCast(r3, RecyclerView.ViewHolder.class, "com.obric.memorydata.plugin"));
        r3.onAttach();
        ((Map) ZeusTransformUtils.preCheckCast(this.createdHolders, Map.class, "com.obric.memorydata.plugin")).put(r3, Unit.INSTANCE);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void onViewDetachedFromWindow(RecyclerView.ViewHolder r3) {
        onViewDetachedFromWindow((BannerViewHolder) ZeusTransformUtils.preCheckCast(r3, BannerViewHolder.class, "com.obric.memorydata.plugin"));
    }

    public void onViewDetachedFromWindow(BannerViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewDetachedFromWindow((RecyclerView.ViewHolder) ZeusTransformUtils.preCheckCast(r3, RecyclerView.ViewHolder.class, "com.obric.memorydata.plugin"));
        r3.onDetach();
        this.createdHolders.remove(r3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder r3) {
        onViewRecycled((BannerViewHolder) ZeusTransformUtils.preCheckCast(r3, BannerViewHolder.class, "com.obric.memorydata.plugin"));
    }

    public void onViewRecycled(BannerViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewRecycled((RecyclerView.ViewHolder) ZeusTransformUtils.preCheckCast(r3, RecyclerView.ViewHolder.class, "com.obric.memorydata.plugin"));
        r3.onViewRecycled();
    }

    public final void registerViewHolder(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "factory");
        this.viewHolderFactoryMap.put(r4.a(), r4);
        this.viewHolderFactoryList.add(r4);
    }

    public final void release() {
        Iterator r3 = ((Map) ZeusTransformUtils.preCheckCast(this.createdHolders, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((BannerViewHolder) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), BannerViewHolder.class, "com.obric.memorydata.plugin")).onDetach();
        goto L4
    }

    public final void setBannerConfig(com.obric.oui.banner.a.a r3) {
        com.obric.oui.banner.a.a r4 = (com.obric.oui.banner.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.banner.a.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "config");
        this.mBannerGridConfig = r4;
    }

    public final void setBannerItemClickListener(com.obric.oui.banner.b.b r3) {
        com.obric.oui.banner.b.b r4 = (com.obric.oui.banner.b.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.banner.b.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onBannerClickListener");
        this.mBannerItemClickListener = r4;
    }

    public final void setCreatedHolders(WeakHashMap<BannerViewHolder, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.createdHolders = r2;
    }

    public final void setDataSet(List<? extends a> r3) {
        List<? extends a> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, EventBody.KEY_VALUE);
        this.dataSet = r4;
        notifyDataSetChanged();
    }

    public final void setUseInfiniteItemCount(boolean r1) {
        this.useInfiniteItemCount = r1;
    }
}
