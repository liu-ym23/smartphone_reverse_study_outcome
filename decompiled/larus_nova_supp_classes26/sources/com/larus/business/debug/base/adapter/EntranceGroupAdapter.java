package com.larus.business.debug.base.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.business.debug.base.adapter.viewHolder.EntranceButtonViewHolder;
import com.larus.business.debug.base.adapter.viewHolder.EntranceInputViewHolder;
import com.larus.business.debug.base.adapter.viewHolder.EntranceSpinnerViewHolder;
import com.larus.business.debug.base.adapter.viewHolder.EntranceSwitchViewHolder;
import com.larus.business.debug.base.adapter.viewHolder.EntranceTextViewHolder;
import com.larus.business.debug.base.adapter.viewHolder.EntranceViewHolder;
import com.larus.business.debug.base.register.EntranceType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zv8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/business/debug/base/adapter/EntranceGroupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/business/debug/base/adapter/viewHolder/EntranceViewHolder;", "debugEntranceList", "", "Lcom/larus/business/debug/base/register/DebugEntrance;", "<init>", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onViewRecycled", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EntranceGroupAdapter extends RecyclerView.Adapter<EntranceViewHolder> {
    public final List<e> a;

    public final int getItemCount() {
        return this.a.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EntranceGroupAdapter(List<? extends e> r2) {
        Intrinsics.checkNotNullParameter(r2, "debugEntranceList");
        this.a = r2;
    }

    public final int getItemViewType(int r2) {
        return ((e) ListProtector.get(this.a, r2)).d().getType();
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        EntranceViewHolder r3 = (EntranceViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewRecycled(r3);
        e r0 = r3.a;
        if (r0 == null) goto L6;
        r3.U3(r0);
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        EntranceViewHolder r4 = (EntranceViewHolder) r2;
        Intrinsics.checkNotNullParameter(r4, "holder");
        r4.T3((e) ListProtector.get(this.a, r3));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 != EntranceType.TEXT.getType()) goto L6;
        return new EntranceTextViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131562016, r4, false));
    L6:
        if (r5 != EntranceType.BUTTON.getType()) goto L9;
        return new EntranceButtonViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131562012, r4, false));
    L9:
        if (r5 != EntranceType.SWITCH.getType()) goto L12;
        return new EntranceSwitchViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131562015, r4, false));
    L12:
        if (r5 != EntranceType.SPINNER.getType()) goto L15;
        return new EntranceSpinnerViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131562014, r4, false));
    L15:
        if (r5 != EntranceType.INPUT.getType()) goto L19;
        return new EntranceInputViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131562013, r4, false));
    L19:
        throw new IllegalArgumentException("Unknown viewType: " + r5);
    }
}
