package com.larus.dora.impl.rebind;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.databinding.LarusDoraGRebindOpItemBinding;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.j0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0011B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/dora/impl/rebind/DoraRebindOpAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/dora/impl/rebind/DoraRebindOpAdapter$DoraRebindOpAdapterViewHolder;", "descriptions", "", "", "<init>", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemCount", "DoraRebindOpAdapterViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraRebindOpAdapter extends RecyclerView.Adapter<DoraRebindOpAdapterViewHolder> {
    public final List<Integer> a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/impl/rebind/DoraRebindOpAdapter$DoraRebindOpAdapterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraGRebindOpItemBinding;", "<init>", "(Lcom/larus/dora/impl/rebind/DoraRebindOpAdapter;Lcom/larus/dora/impl/databinding/LarusDoraGRebindOpItemBinding;)V", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusDoraGRebindOpItemBinding;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DoraRebindOpAdapterViewHolder extends RecyclerView.ViewHolder {
        public final LarusDoraGRebindOpItemBinding a;

        public DoraRebindOpAdapterViewHolder(LarusDoraGRebindOpItemBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public DoraRebindOpAdapter(List<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptions");
        this.a = r2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        DoraRebindOpAdapterViewHolder r5 = (DoraRebindOpAdapterViewHolder) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        AppCompatTextView r6 = r5.a.b;
        StringBuilder r0 = new StringBuilder();
        r0.append(r4);
        r0.append('.');
        int r1 = j0.a;
        r0.append(j0.d(((Number) ListProtector.get(this.a, r4)).intValue()));
        r6.setText(r0.toString());
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562203, r3, false);
        DoraTextView r0 = (DoraTextView) ViewBindings.findChildViewById(r5, 2131369989);
        if (r0 == null) goto L7;
        return new DoraRebindOpAdapterViewHolder(new LarusDoraGRebindOpItemBinding((LinearLayout) r5, r0));
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131369989)));
    }
}
