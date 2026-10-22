package com.bytedance.android.live.browser.debug.mock;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q20.i;
import r20.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/browser/debug/mock/MappingConfigAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/browser/debug/mock/MappingConfigAdapter$ViewHolder;", "ViewHolder", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MappingConfigAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final List<b> a;
    public final FragmentActivity b;
    public final Uri c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/browser/debug/mock/MappingConfigAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final TextView b;

        public final String toString() {
            return super.toString() + " '" + this.b.getText() + "'";
        }

        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = (TextView) r2.findViewById(2131375812);
            this.b = (TextView) r2.findViewById(2131367794);
        }
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        ViewHolder r5 = (ViewHolder) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        b r0 = (b) ListProtector.get(this.a, r4);
        r5.a.setText(String.valueOf(r4 + 1));
        r5.b.setText(r0.a);
        r5.b.setOnClickListener(new i(this, r0));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new ViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131561217, r3, false));
    }

    public MappingConfigAdapter(List<b> r2, FragmentActivity r3, Uri r4) {
        Intrinsics.checkNotNullParameter(r2, "values");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "originUri");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
