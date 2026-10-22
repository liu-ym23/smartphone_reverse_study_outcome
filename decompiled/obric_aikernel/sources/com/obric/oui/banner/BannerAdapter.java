package com.obric.oui.banner;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.crash.entity.EventBody;
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

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010:\u001a\u000209¢\u0006\u0004\b;\u0010<J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tJ\b\u0010\f\u001a\u00020\u0007H\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0006\u0010\u0018\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019R.\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R6\u0010-\u001a\b\u0012\u0004\u0012\u00020+0*2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00105\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0003038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020\u0003078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010.¨\u0006="}, d2 = {"Lcom/obric/oui/banner/BannerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/oui/banner/BannerViewHolder;", "Lcom/obric/oui/banner/c;", "factory", "", "registerViewHolder", "", "getRealItemCount", "Lk9/b;", "onBannerClickListener", "setBannerItemClickListener", "getItemCount", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "holder", "position", "onBindViewHolder", "getItemViewType", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewRecycled", "release", "Lj9/a;", "config", "setBannerConfig", "Ljava/util/WeakHashMap;", "createdHolders", "Ljava/util/WeakHashMap;", "getCreatedHolders", "()Ljava/util/WeakHashMap;", "setCreatedHolders", "(Ljava/util/WeakHashMap;)V", "", "useInfiniteItemCount", "Z", "getUseInfiniteItemCount", "()Z", "setUseInfiniteItemCount", "(Z)V", "", "Lcom/obric/oui/banner/a;", EventBody.KEY_VALUE, "dataSet", "Ljava/util/List;", "getDataSet", "()Ljava/util/List;", "setDataSet", "(Ljava/util/List;)V", "", "", "viewHolderFactoryMap", "Ljava/util/Map;", "", "viewHolderFactoryList", "Lk9/a;", "bannerOperator", "<init>", "(Lk9/a;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class BannerAdapter extends RecyclerView.Adapter<BannerViewHolder> {
    private final k9.a bannerOperator;
    private WeakHashMap<BannerViewHolder, Unit> createdHolders;
    private List<? extends com.obric.oui.banner.a> dataSet;
    private j9.a mBannerGridConfig;
    private k9.b mBannerItemClickListener;
    private boolean useInfiniteItemCount;
    private final List<c> viewHolderFactoryList;
    private final Map<String, c> viewHolderFactoryMap;

    static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BannerAdapter f6225c;

        a(BannerAdapter r10) {
            this.f6225c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            Object r11 = r10.getTag(u8.f.banner_pos_key);
            Objects.requireNonNull(r11, "null cannot be cast to non-null type kotlin.Int");
            int r12 = ((Integer) r11).intValue();
            k9.b r13 = BannerAdapter.access$getMBannerItemClickListener$p(this.f6225c);
            if (r13 == null) goto L6;
            r13.a(this.f6225c.getDataSet().get(r12), r12);
            return;
        }
    }

    public BannerAdapter(k9.a r10) {
        Intrinsics.checkNotNullParameter(r10, "bannerOperator");
        this.bannerOperator = r10;
        this.viewHolderFactoryMap = new LinkedHashMap();
        this.viewHolderFactoryList = new ArrayList();
        this.createdHolders = new WeakHashMap();
        this.dataSet = CollectionsKt.emptyList();
        this.useInfiniteItemCount = true;
        registerViewHolder(StubViewHolder.Companion);
    }

    public static final /* synthetic */ k9.b access$getMBannerItemClickListener$p(BannerAdapter r10) {
        return r10.mBannerItemClickListener;
    }

    public static final /* synthetic */ void access$setMBannerItemClickListener$p(BannerAdapter r10, k9.b r11) {
        r10.mBannerItemClickListener = r11;
    }

    public final WeakHashMap<BannerViewHolder, Unit> getCreatedHolders() {
        return this.createdHolders;
    }

    public final List<com.obric.oui.banner.a> getDataSet() {
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
    public int getItemViewType(int r10) {
        if (this.viewHolderFactoryList.isEmpty() == true) goto L11;
        if (this.dataSet.isEmpty() == false) goto L7;
        String r11 = StubViewHolder.Companion.getKey();
    L8:
        c r12 = this.viewHolderFactoryMap.get(r11);
        return CollectionsKt.indexOf(this.viewHolderFactoryList, r12);
    L7:
        List<? extends com.obric.oui.banner.a> r13 = this.dataSet;
        r11 = r13.get(r10 % r13.size()).a();
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
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        onBindViewHolder((BannerViewHolder) r10, r11);
    }

    public void onBindViewHolder(BannerViewHolder r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        int r12 = l9.a.f10916a.a(this.useInfiniteItemCount, r11, getRealItemCount());
        if (this.dataSet.isEmpty() == false) goto L6;
        r10.onBind(r12, new f());
        return;
    L6:
        com.obric.oui.banner.a r13 = this.dataSet.get(r12);
        if ((r13 instanceof b) == false) goto L9;
        ((b) r13).b(this.mBannerGridConfig);
    L9:
        r10.onBind(r12, r13);
        r10.itemView.setTag(u8.f.banner_pos_key, Integer.valueOf(r12));
        if (r10.itemView.hasOnClickListeners() == true) goto L13;
        r10.itemView.setOnClickListener(new a(this));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        return onCreateViewHolder(r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BannerViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        if (this.viewHolderFactoryList.isEmpty() == true) goto L7;
        BannerViewHolder r12 = this.viewHolderFactoryList.get(r11).a(r10);
        r12.setBannerOperator(this.bannerOperator);
        return r12;
    L7:
        throw new IllegalStateException("Register your BannerViewHolder into the Banner ~ ");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder r10) {
        onViewAttachedToWindow((BannerViewHolder) r10);
    }

    public void onViewAttachedToWindow(BannerViewHolder r10) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        super.onViewAttachedToWindow(r10);
        r10.onAttach();
        this.createdHolders.put(r10, Unit.INSTANCE);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewDetachedFromWindow(RecyclerView.ViewHolder r10) {
        onViewDetachedFromWindow((BannerViewHolder) r10);
    }

    public void onViewDetachedFromWindow(BannerViewHolder r10) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        super.onViewDetachedFromWindow(r10);
        r10.onDetach();
        this.createdHolders.remove(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder r10) {
        onViewRecycled((BannerViewHolder) r10);
    }

    public void onViewRecycled(BannerViewHolder r10) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        super.onViewRecycled(r10);
        r10.onViewRecycled();
    }

    public final void registerViewHolder(c r10) {
        Intrinsics.checkNotNullParameter(r10, "factory");
        this.viewHolderFactoryMap.put(r10.getKey(), r10);
        this.viewHolderFactoryList.add(r10);
    }

    public final void release() {
        Iterator<Map.Entry<BannerViewHolder, Unit>> r10 = this.createdHolders.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().getKey().onDetach();
        goto L4
    }

    public final void setBannerConfig(j9.a r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        this.mBannerGridConfig = r10;
    }

    public final void setBannerItemClickListener(k9.b r10) {
        Intrinsics.checkNotNullParameter(r10, "onBannerClickListener");
        this.mBannerItemClickListener = r10;
    }

    public final void setCreatedHolders(WeakHashMap<BannerViewHolder, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.createdHolders = r10;
    }

    public final void setDataSet(List<? extends com.obric.oui.banner.a> r10) {
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        this.dataSet = r10;
        notifyDataSetChanged();
    }

    public final void setUseInfiniteItemCount(boolean r10) {
        this.useInfiniteItemCount = r10;
    }
}
