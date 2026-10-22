package com.bytedance.android.live.livepkaudience.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r extends me.drakeet.multitype.b<a, SimplePkGuestApplyFootHolder> {
    public r() {
    }

    public final void b(RecyclerView.ViewHolder r4, Object r5) {
        SimplePkGuestApplyFootHolder r6 = (SimplePkGuestApplyFootHolder) r4;
        a r7 = (a) r5;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "item");
        int r8 = r7.getType();
        View r0 = ((RecyclerView.ViewHolder) r6).itemView;
        if (r0 == null) goto L27;
        TextView r1 = (TextView) r0;
        if (r8 != 0) goto L7;
        int r9 = s1.f(60.0f);
        ViewGroup.LayoutParams r2 = ((RecyclerView.ViewHolder) r6).itemView.getLayoutParams();
        if (r2 == null) goto L20;
        r2.height = r9;
        ((RecyclerView.ViewHolder) r6).itemView.setLayoutParams(r2);
    L20:
        View r10 = ((RecyclerView.ViewHolder) r6).itemView;
        if (r10 == null) goto L25;
        ((TextView) r10).setText(2131921546);
        return;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L7:
        if (r8 != 1) goto L29;
        int r11 = s1.f(60.0f);
        ViewGroup.LayoutParams r3 = ((RecyclerView.ViewHolder) r6).itemView.getLayoutParams();
        if (r3 == null) goto L12;
        r3.height = r11;
        ((RecyclerView.ViewHolder) r6).itemView.setLayoutParams(r3);
    L12:
        View r12 = ((RecyclerView.ViewHolder) r6).itemView;
        if (r12 == null) goto L16;
        ((TextView) r12).setText(2131921548);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L29:
        return;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new SimplePkGuestApplyFootHolder(r4.inflate(2131566247, r5, false));
    }
}
