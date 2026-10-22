package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/search/SearchHistoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/search/SearchHistoryAdapter$ViewHolder;", "ViewHolder", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchHistoryAdapter extends RecyclerView.Adapter<ViewHolder> {
    public List<String> a;
    public final Function2<Integer, String, Unit> b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/search/SearchHistoryAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final ImageView b;
        public final Function2<Integer, String, Unit> c;

        public ViewHolder(View r2, Function2 r3) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "clickCallback");
            super(r2);
            this.c = r3;
            this.a = (TextView) r2.findViewById(2131374414);
            this.b = (ImageView) r2.findViewById(2131374396);
        }
    }

    public final int getItemCount() {
        return this.a.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchHistoryAdapter(List<String> r2, Function2<? super Integer, ? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "historyList");
        Intrinsics.checkNotNullParameter(r3, "clickCallback");
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        ViewHolder r8 = (ViewHolder) r6;
        Intrinsics.checkNotNullParameter(r8, "holder");
        String r9 = (String) ListProtector.get(this.a, r7);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "text");
        r8.a.setText(r9);
        View r0 = ((RecyclerView.ViewHolder) r8).itemView;
        Object r1 = n80.a.a;
        n80.b r2 = new n80.b(r0);
        TimeUnit r3 = TimeUnit.MILLISECONDS;
        r2.throttleFirst(500, r3).subscribe(new n(r8, r9));
        new n80.b(r8.b).throttleFirst(500, r3).subscribe(new o(r8, r9));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131566945, r4, false), this.b);
    }
}
