package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.data.m;
import com.bytedance.android.live.base.model.message.m1;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PSMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$ViewBinderType;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements com.bytedance.android.livesdk.interactivity.api.publicscreen.j<g, PSInteractivityShareMessageViewHolder> {
    public final PublicScreenConfig$ViewBinderType a;
    public final Function2<m1, Context, Unit> b;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.j
    public final PublicScreenConfig$ViewBinderType a() {
        return this.a;
    }

    public h(Function2<? super m1, ? super Context, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onShareItemClick");
        this.b = r2;
        this.a = PublicScreenConfig$ViewBinderType.INTERACTIVITY_SHARE;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.j
    public final PSMessageViewHolder c(LayoutInflater r2, ViewGroup r3, g52.c r4) {
        Intrinsics.checkNotNullParameter(r2, "layoutInflater");
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = r2.inflate(2131566376, r3, false);
        if (r5.getLayoutParams() != null) goto L6;
        r5.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    L6:
        return new PSInteractivityShareMessageViewHolder(r5, this.b);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.j
    public final void b(PSMessageViewHolder r4, com.bytedance.android.livesdk.interactivity.api.publicscreen.i r5, int r6, g52.e r7) {
        PSInteractivityShareMessageViewHolder r8 = (PSInteractivityShareMessageViewHolder) r4;
        g r9 = (g) r5;
        Intrinsics.checkNotNullParameter(r8, "viewHolder");
        Intrinsics.checkNotNullParameter(r9, "item");
        r8.W3(r9, r7);
        m1 r10 = r9.l;
        Intrinsics.checkNotNullParameter(r10, "message");
        m r11 = r10.getItemStyle();
        if (r11 == null) goto L13;
        ImageUtil.loadImageWithRadius(r8.l, r11.icon, 0, 4);
        r8.m.setText(r11.name);
        TextView r13 = r8.m;
        int r14 = Color.parseColor(r11.nameColor);     // Catch: Exception -> L8
    L9:
        r13.setTextColor(r14);
        r8.n.setOnClickListener(new i(r8, r10));
        ((RecyclerView.ViewHolder) r8).itemView.setOnClickListener(r8.e);
        return;
    L8:
        r14 = -1;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.j
    public final void d(PSMessageViewHolder r2, com.bytedance.android.livesdk.interactivity.api.publicscreen.i r3, int r4, g52.e r5) {
        Intrinsics.checkNotNullParameter(r2, "viewHolder");
        Intrinsics.checkNotNullParameter(r3, "item");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.j.a.a(this, r2, r3, r4, r5);
    }
}
