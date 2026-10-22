package com.larus.dora.impl.device_v2.adapter;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.databinding.LarusDoraHistoryDeviceInfoLayoutBinding;
import com.larus.dora.impl.device_v2.viewholder.HistoryDeviceInfoHolder;
import com.larus.dora.impl.dynamic.BaseViewHolder;
import e59.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y49.a;
import z49.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018J\u001e\u0010!\u001a\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0#2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0014\u0010$\u001a\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0#J\u0006\u0010%\u001a\u00020\u0012J\u0018\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001aH\u0016J\u0018\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u001aH\u0016J\b\u0010-\u001a\u00020\u001aH\u0016J\u0010\u0010.\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u001aH\u0016J\u000e\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u000201J\u000e\u00102\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u00063"}, d2 = {"Lcom/larus/dora/impl/device_v2/adapter/HistoryDeviceListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "viewHolderMap", "Landroid/util/SparseArray;", "Ljava/lang/Class;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/device_v2/entity/HistoryDeviceListInfo;", "items", "", "itemCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "loadMoreListener", "Lkotlin/Function0;", "", "isLoading", "", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "listener", "Lcom/larus/dora/impl/device_v2/adapter/OnItemClickListener;", "value", "", "selectedPosition", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "setOnItemClickListener", "setData", "newItems", "", "addData", "onLoadMoreComplete", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "getItemViewType", "enableLoadMore", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getItem", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HistoryDeviceListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final b.d a;
    public final List<c> b;

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public HistoryDeviceListAdapter() {
        this.a = b.d.a;
        new SparseArray();
        this.b = new ArrayList();
    }

    public final int getItemViewType(int r2) {
        String r3 = ((c) ListProtector.get(this.b, r2)).b();
        if (r3 != null) goto L7;
        return 0;
    L7:
        return r3.hashCode();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, final int r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        View r0 = r5.itemView;
        boolean r1 = false;
        if (r6 != 0) goto L5;
        boolean r3 = true;
    L6:
        r0.setSelected(r3);
        List<c> r2 = this.b;
        c r4 = (c) ListProtector.get(r2, r6);
        if (r6 != 0) goto L9;
        r1 = true;
    L9:
        ListProtector.set(r2, r6, c.a(r4, Boolean.valueOf(r1)));
        ((BaseViewHolder) r5).T3(ListProtector.get(this.b, r6), this.a, null);
        r5.itemView.setOnClickListener(new a(this, r6));
        return;
    L5:
        r3 = false;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        int r0 = HistoryDeviceInfoHolder.c;
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562210, r3, false);
        int r6 = 2131374398;
        SimpleDraweeView r1 = ViewBindings.findChildViewById(r5, 2131374398);
        if (r1 == null) goto L9;
        r6 = 2131374399;
        AppCompatTextView r2 = ViewBindings.findChildViewById(r5, 2131374399);
        if (r2 == null) goto L9;
        return new HistoryDeviceInfoHolder(new LarusDoraHistoryDeviceInfoLayoutBinding((LinearLayout) r5, r1, r2));
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
