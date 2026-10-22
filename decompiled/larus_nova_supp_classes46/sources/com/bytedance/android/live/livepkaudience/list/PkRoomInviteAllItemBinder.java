package com.bytedance.android.live.livepkaudience.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.x0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class PkRoomInviteAllItemBinder extends me.drakeet.multitype.b<n, ViewHolder> {
    public final Function0<Unit> b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/list/PkRoomInviteAllItemBinder$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;

        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (TextView) r2.findViewById(2131390582);
        }
    }

    public PkRoomInviteAllItemBinder(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onClick");
        this.b = r2;
    }

    public final void b(RecyclerView.ViewHolder r4, Object r5) {
        ViewHolder r6 = (ViewHolder) r4;
        n r7 = (n) r5;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "item");
        r6.a.setText(s1.C(2131918024, new Object[]{Integer.valueOf(r7.a)}));
        ((RecyclerView.ViewHolder) r6).itemView.setOnClickListener(x0.a(new PkRoomInviteAllItemBinder$onBindViewHolder$1(this)));
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new ViewHolder(r4.inflate(2131566353, r5, false));
    }
}
