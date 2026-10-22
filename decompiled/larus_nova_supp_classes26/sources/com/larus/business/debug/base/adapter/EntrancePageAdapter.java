package com.larus.business.debug.base.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.business.debug.base.adapter.viewHolder.EntranceGroupViewHolder;
import com.larus.business.debug.base.register.EntranceGroup;
import com.larus.business.debug.base.register.EntrancePage;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import zv8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0006\u0010\u0017\u001a\u00020\u0011R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/business/debug/base/adapter/EntrancePageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/business/debug/base/adapter/viewHolder/EntranceGroupViewHolder;", "entranceGroupList", "", "Lcom/larus/business/debug/base/register/EntranceGroup;", "page", "Lcom/larus/business/debug/base/register/EntrancePage;", "<init>", "(Ljava/util/List;Lcom/larus/business/debug/base/register/EntrancePage;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "payloads", "", "onViewRecycled", "refreshData", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EntrancePageAdapter extends RecyclerView.Adapter<EntranceGroupViewHolder> {
    public final List<EntranceGroup> a;
    public final EntrancePage b;

    public final int getItemCount() {
        return this.a.size();
    }

    public final void y2() {
        k r0 = k.a;
        EntrancePage r1 = this.b;
        r0.getClass();
        List r2 = k.c(r1);
        DiffUtil.calculateDiff(new EntrancePageDiffCallback(this.a, r2)).dispatchUpdatesTo(this);
        List<EntranceGroup> r3 = this.a;
        if (TypeIntrinsics.isMutableList(r3) == true) goto L6;
        r3 = null;
    L6:
        if (r3 == null) goto L9;
        r3.clear();
        r3.addAll(r2);
        return;
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r3) {
        EntranceGroupViewHolder r4 = (EntranceGroupViewHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        super.onViewRecycled(r4);
        TextView r0 = r4.c;
        if (r0 == null) goto L5;
        r0.setText("");
    L5:
        r4.c = null;
        r4.b = null;
        r4.d = null;
    }

    public EntrancePageAdapter(List<EntranceGroup> r2, EntrancePage r3) {
        Intrinsics.checkNotNullParameter(r2, "entranceGroupList");
        Intrinsics.checkNotNullParameter(r3, "page");
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        EntranceGroupViewHolder r4 = (EntranceGroupViewHolder) r2;
        Intrinsics.checkNotNullParameter(r4, "holder");
        r4.T3((EntranceGroup) ListProtector.get(this.a, r3), this.b);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new EntranceGroupViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131562011, r4, false));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List r4) {
        EntranceGroupViewHolder r5 = (EntranceGroupViewHolder) r2;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        r5.T3((EntranceGroup) ListProtector.get(this.a, r3), this.b);
    }
}
