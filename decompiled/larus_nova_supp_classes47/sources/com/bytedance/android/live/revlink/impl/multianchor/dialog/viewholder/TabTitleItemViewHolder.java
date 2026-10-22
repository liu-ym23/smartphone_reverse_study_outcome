package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/viewholder/TabTitleItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TabTitleItemViewHolder extends RecyclerView.ViewHolder {
    public final TextView a;
    public final a b;
    public Integer c;
    public MutableLiveData<Integer> d;

    public static final class a<T> implements Observer {
        public final /* synthetic */ TabTitleItemViewHolder a;
        public final /* synthetic */ View b;

        public a(TabTitleItemViewHolder r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            this.b.setSelected(Intrinsics.areEqual((Integer) r3, this.a.c));
        }
    }

    public TabTitleItemViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = (TextView) r2.findViewById(2131390822);
        this.b = new a(this, r2);
    }
}
