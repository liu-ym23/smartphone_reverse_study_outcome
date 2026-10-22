package com.bytedance.android.live.broadcastgame.opengame.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w extends me.drakeet.multitype.b<com.bytedance.android.live.broadcastgame.opengame.network.f.a, RankItemViewHolder> {
    public w() {
    }

    public final void b(RecyclerView.ViewHolder r7, Object r8) {
        RankItemViewHolder r9 = (RankItemViewHolder) r7;
        com.bytedance.android.live.broadcastgame.opengame.network.f.a r11 = (com.bytedance.android.live.broadcastgame.opengame.network.f.a) r8;
        Intrinsics.checkNotNullParameter(r9, "holder");
        Intrinsics.checkNotNullParameter(r11, "item");
        r9.getClass();
        Intrinsics.checkNotNullParameter(r11, "info");
        int r0 = r9.getAdapterPosition();
        r9.a.setText(String.valueOf(r0));
        TextView r1 = r9.a;
        if (r0 != 1) goto L5;
        int r2 = ColorProtector.parseColor("#FF2935");
    L12:
        r1.setTextColor(r2);
        ImageUtil.loadRoundImage(r9.b, new ImageModel(r11.a(), CollectionsKt.mutableListOf(new String[]{r11.a()})));
        r9.c.setText(r11.c());
        r9.d.setText(b.a(r11.b()));
        return;
    L5:
        if (r0 != 2) goto L7;
        r2 = ColorProtector.parseColor("#FF6421");
        goto L12
    L7:
        if (r0 == 3) goto L9;
        r2 = ColorProtector.parseColor("#ffffff");
        goto L12
    L9:
        r2 = ColorProtector.parseColor("#F3AF00");
        goto L12
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new RankItemViewHolder(LayoutInflater.from(r5.getContext()).inflate(2131565446, r5, false));
    }
}
