package com.bytedance.android.live.liveinteract.linkpanel.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class ListTitleItemBinder extends me.drakeet.multitype.b<q, ViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/list/ListTitleItemBinder$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public ListTitleItemBinder() {
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        ViewHolder r4 = (ViewHolder) r2;
        q r5 = (q) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        View r6 = ((RecyclerView.ViewHolder) r4).itemView;
        if (r6 == null) goto L20;
        TextView r7 = (TextView) r6;
        byte r8 = r5.getType();
        if (r8 != 1) goto L7;
        String r9 = s1.B(2131918036);
    L17:
        r7.setText(r9);
        return;
    L7:
        if (r8 != 2) goto L9;
        r9 = s1.B(2131918038);
        goto L17
    L9:
        if (r8 != 4) goto L11;
        r9 = s1.B(2131921185);
        goto L17
    L11:
        if (r8 == 8) goto L13;
        r9 = null;
        goto L17
    L13:
        r9 = s1.B(2131921177);
        goto L17
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new ViewHolder(r4.inflate(2131566411, r5, false));
    }
}
