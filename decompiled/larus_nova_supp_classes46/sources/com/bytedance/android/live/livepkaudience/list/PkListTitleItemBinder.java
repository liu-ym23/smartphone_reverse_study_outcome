package com.bytedance.android.live.livepkaudience.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceInviteListFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class PkListTitleItemBinder extends me.drakeet.multitype.b<k, ViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/list/PkListTitleItemBinder$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public PkListTitleItemBinder() {
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        ViewHolder r4 = (ViewHolder) r2;
        k r5 = (k) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        View r6 = ((RecyclerView.ViewHolder) r4).itemView;
        if (r6 == null) goto L17;
        TextView r7 = (TextView) r6;
        byte r8 = r5.getType();
        int r0 = BasePkAudienceInviteListFragment.A;
        if (r8 != 1) goto L8;
        String r9 = s1.B(2131918036);
    L14:
        r7.setText(r9);
        return;
    L8:
        if (r8 != 2) goto L11;
        r9 = s1.B(2131918038);
        goto L14
    L11:
        if (r8 != 4) goto L13;
        r9 = s1.B(2131921185);
        goto L14
    L13:
        r9 = null;
        goto L14
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new ViewHolder(r4.inflate(2131566354, r5, false));
    }
}
