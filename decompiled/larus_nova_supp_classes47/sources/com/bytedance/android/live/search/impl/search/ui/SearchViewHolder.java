package com.bytedance.android.live.search.impl.search.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/ui/SearchViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchViewHolder extends RecyclerView.ViewHolder {
    public final HSImageView a;
    public final Function3<? super Integer, ? super Integer, ? super View, Unit> b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SearchViewHolder a;

        public a(SearchViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            Function3<? super Integer, ? super Integer, ? super View, Unit> r0 = this.a.b;
            if (r0 == null) goto L6;
            Unit r5 = (Unit) r0.invoke(1, Integer.valueOf(this.a.getAdapterPosition()), r4);
            return;
        }
    }

    public SearchViewHolder(ViewGroup r4, Function3<? super Integer, ? super Integer, ? super View, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        super(LayoutInflater.from(r4.getContext()).inflate(2131567426, r4, false));
        this.b = r5;
        View r6 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r6 instanceof HSImageView) == true) goto L5;
        r6 = null;
    L5:
        HSImageView r7 = (HSImageView) r6;
        this.a = r7;
        if (r7 == null) goto L9;
        r7.setOnClickListener(new a(this));
        return;
    }
}
