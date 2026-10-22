package com.larus.bot.impl.feature.discover.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import bb8.i;
import bb8.j;
import by7.e;
import com.larus.bmhome.banner.BannerItemViewHolder;
import com.larus.bot.impl.feature.discover.BotDiscoverListFragment;
import com.larus.business.banner.databinding.LarusItemBannerBinding;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import su8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00172\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/bot/impl/feature/discover/adapter/BotDiscoverListHeaderAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/bmhome/banner/BannerItemViewHolder;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "<init>", "(Landroidx/lifecycle/Lifecycle;Lcom/ixigua/lib/track/ITrackNode;)V", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "setLifecycle", "(Landroidx/lifecycle/Lifecycle;)V", "bannerData", "", "Lcom/larus/bmhome/banner/BannerModel;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "hasValidBanner", "", "refreshData", "data", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotDiscoverListHeaderAdapter extends RecyclerView.Adapter<BannerItemViewHolder> {
    public Lifecycle a;
    public final e b;
    public List<i> c;

    public final boolean y2() {
        List<i> r0 = this.c;
        if (r0 == null) goto L11;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        if (j.a((i) r1.next()) == true) goto L6;
        return true;
    L16:
        return false;
    L11:
        return false;
    }

    public final int getItemCount() {
        return y2() ? 1 : 0;
    }

    public BotDiscoverListHeaderAdapter(Lifecycle r2, BotDiscoverListFragment r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycle");
        Intrinsics.checkNotNullParameter(r3, "trackNode");
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        final BannerItemViewHolder r4 = (BannerItemViewHolder) r2;
        Intrinsics.checkNotNullParameter(r4, "holder");
        if (y2() == false) goto L5;
        List<i> r5 = this.c;
        Intrinsics.checkNotNull(r5);
        r4.T3(r5);
        return;
    L5:
        ((RecyclerView.ViewHolder) r4).itemView.post(new c(r4, this));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new BannerItemViewHolder(LarusItemBannerBinding.a(LayoutInflater.from(r3.getContext()), r3), this.a, this.b);
    }
}
