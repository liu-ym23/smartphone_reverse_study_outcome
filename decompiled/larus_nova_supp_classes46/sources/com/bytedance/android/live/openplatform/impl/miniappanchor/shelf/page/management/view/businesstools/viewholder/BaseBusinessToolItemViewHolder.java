package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.utils.w0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/businesstools/viewholder/BaseBusinessToolItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseBusinessToolItemViewHolder extends RecyclerView.ViewHolder {
    public final TextView a;
    public final TextView b;
    public final ImageView c;
    public final a d;

    public interface a {
        void E(bq0.a r1);

        void g1(bq0.a r1);
    }

    public void T3(final bq0.a r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        this.a.setText(r6.c());
        this.b.setText(r6.a);
        this.c.setImageResource(r6.a());
        this.d.E(r6);
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new w0(new BaseBusinessToolItemViewHolder$onBindViewHolder$1(this, r6), 500));
    }

    public BaseBusinessToolItemViewHolder(View r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "businessToolItemListener");
        super(r2);
        this.d = r3;
        this.a = (TextView) r2.findViewById(2131364976);
        this.b = (TextView) r2.findViewById(2131364971);
        this.c = (ImageView) r2.findViewById(2131364975);
    }
}
