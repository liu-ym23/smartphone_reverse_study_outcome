package com.bytedance.android.live.livepkaudience.list;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/list/PkSimplePreApplyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkSimplePreApplyViewHolder extends RecyclerView.ViewHolder {
    public final TextView a;
    public final HSImageView b;
    public final TextView c;
    public final TextView d;
    public final LinearLayout e;
    public final Map<dl0.c, View> f;

    /* JADX WARN: Multi-variable type inference failed */
    public PkSimplePreApplyViewHolder(View r2, Map<dl0.c, ? extends View> r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "badgeTypeMap");
        super(r2);
        this.f = r3;
        this.a = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391017);
        this.b = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376286);
        this.c = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390975);
        this.d = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390479);
        this.e = (LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131380597);
    }
}
