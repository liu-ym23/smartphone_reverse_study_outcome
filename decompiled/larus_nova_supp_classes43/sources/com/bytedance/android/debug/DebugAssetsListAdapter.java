package com.bytedance.android.debug;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0006\u0007B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/bytedance/android/debug/DebugAssetsListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/debug/DebugAssetsListAdapter$AssetHolder;", "Landroid/widget/Filterable;", "<init>", "()V", "AssetHolder", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DebugAssetsListAdapter extends RecyclerView.Adapter<AssetHolder> implements Filterable {
    public final List<com.bytedance.android.live.core.resources.e> a;
    public final List<com.bytedance.android.live.core.resources.e> b;
    public a c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/debug/DebugAssetsListAdapter$AssetHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AssetHolder extends RecyclerView.ViewHolder {
        public final TextView a;

        public AssetHolder(View r10) {
            Intrinsics.checkNotNullParameter(r10, "itemView");
            super(r10);
            View r11 = r10.findViewById(2131363260);
            if (r11 == null) goto L7;
            this.a = (TextView) r11;
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public interface a {
        void a(com.bytedance.android.live.core.resources.e r1);
    }

    public static final class b extends Filter {
        public final /* synthetic */ DebugAssetsListAdapter a;

        public b(DebugAssetsListAdapter r1) {
            this.a = r1;
        }

        @Override // android.widget.Filter
        public final Filter.FilterResults performFiltering(CharSequence r10) {
            String r11 = String.valueOf(r10);
            Filter.FilterResults r0 = new Filter.FilterResults();
            if (r11.length() != 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L8;
            ArrayList r12 = new ArrayList();
            r12.addAll(this.a.a);
            r0.values = r12;
        L15:
            return r0;
        L8:
            ArrayList r13 = new ArrayList();
            Iterator r14 = ((ArrayList) this.a.a).iterator();
        L10:
            if (r14.hasNext() == false) goto L14;
            com.bytedance.android.live.core.resources.e r15 = (com.bytedance.android.live.core.resources.e) r14.next();
            if (StringsKt.contains$default(String.valueOf(r15.getId()) + r15.getName(), r11, false, 2, null) == false) goto L10;
            r13.add(r15);
            goto L10
        L14:
            r0.values = r13;
            goto L15
        L5:
            r1 = false;
            goto L6
        }

        @Override // android.widget.Filter
        public final void publishResults(CharSequence r10, Filter.FilterResults r11) {
            Object r12 = null;
            if (r11 == null) goto L5;
            Object r0 = r11.values;
        L6:
            if (r0 == null) goto L17;
            Object r13 = r11.values;
            if (TypeIntrinsics.isMutableList(r13) == false) goto L11;
            r12 = r13;
        L11:
            List r14 = (List) r12;
            if (r14 == null) goto L16;
            List r15 = r14;
            if ((!r15.isEmpty()) == false) goto L16;
            ((ArrayList) this.a.b).clear();
            ((ArrayList) this.a.b).addAll(r15);
        L16:
            ((ArrayList) this.a.b).clear();
        L17:
            this.a.notifyDataSetChanged();
            return;
        L5:
            r0 = null;
            goto L6
        }
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        return new b(this);
    }

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public DebugAssetsListAdapter() {
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        AssetHolder r12 = (AssetHolder) r10;
        Intrinsics.checkNotNullParameter(r12, "holder");
        TextView r0 = r12.a;
        StringBuilder r1 = new StringBuilder();
        r1.append(String.valueOf(((com.bytedance.android.live.core.resources.e) ListProtector.get(this.b, r11)).getId()));
        r1.append(": ");
        String r13 = ((com.bytedance.android.live.core.resources.e) ListProtector.get(this.b, r11)).getName();
        if (r13 == null) goto L5;
        String r14 = StringsKt.trim(r13).toString();
    L6:
        r1.append(r14);
        r0.setText(r1.toString());
        ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(new com.bytedance.android.debug.a(this, r11));
        return;
    L5:
        r14 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "viewGroup");
        return new AssetHolder(LayoutInflater.from(r10.getContext()).inflate(2131566134, null));
    }
}
