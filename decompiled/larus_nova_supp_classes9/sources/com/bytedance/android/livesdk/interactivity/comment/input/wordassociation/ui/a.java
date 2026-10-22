package com.bytedance.android.livesdk.interactivity.comment.input.wordassociation.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import c32.d;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends me.drakeet.multitype.b<com.bytedance.android.livesdk.interactivity.api.emoji.a, FusionEmojiViewHolder> {
    public final g b;
    public final d c;
    public final long d;

    public final void b(RecyclerView.ViewHolder r6, Object r7) {
        final FusionEmojiViewHolder r8 = (FusionEmojiViewHolder) r6;
        final com.bytedance.android.livesdk.interactivity.api.emoji.a r9 = (com.bytedance.android.livesdk.interactivity.api.emoji.a) r7;
        Intrinsics.checkNotNullParameter(r8, "holder");
        Intrinsics.checkNotNullParameter(r9, "emoji");
        int r1 = ((me.drakeet.multitype.b) this).a.getItemCount();
        boolean r3 = true;
        if (r8.getAdapterPosition() == (r1 - 1)) goto L6;
        r3 = false;
    L6:
        final Function1<com.bytedance.android.livesdk.interactivity.api.emoji.a, Unit> r2 = new FusionEmojiItemBinder$onBindViewHolder$1(this, r9);
        Intrinsics.checkNotNullParameter(r9, "emoji");
        Intrinsics.checkNotNullParameter(r2, "clickRunnable");
        if (r3 == false) goto L9;
        UtilityKotlinExtentionsKt.t(r8.b);
    L9:
        k r0 = r9.a();
        if (r0 == null) goto L12;
        ImageUtil.loadImage(r8.a, r0, 0);
        ((RecyclerView.ViewHolder) r8).itemView.setOnClickListener(x0.a(new FusionEmojiViewHolder$bind$$inlined$let$lambda$1(r8, r2, r9)));
    L12:
        r3.a(((RecyclerView.ViewHolder) r8).itemView, r9.d());
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new FusionEmojiViewHolder(r3.inflate(2131566099, r4, false));
    }

    public a(g r2, d r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "item");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
