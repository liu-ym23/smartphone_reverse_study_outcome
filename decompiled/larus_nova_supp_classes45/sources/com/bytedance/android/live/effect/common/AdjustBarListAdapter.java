package com.bytedance.android.live.effect.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.effect.base.BeautifyAdjustPercentBar;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/effect/common/AdjustBarListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/common/AdjustBarListAdapter$AdjustBarViewHolder;", "AdjustBarViewHolder", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdjustBarListAdapter extends RecyclerView.Adapter<AdjustBarViewHolder> {
    public Sticker a;
    public final Map<String, Integer> b;
    public final d c;
    public final b d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/common/AdjustBarListAdapter$AdjustBarViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class AdjustBarViewHolder extends RecyclerView.ViewHolder {
        public AdjustBarViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public final int getItemCount() {
        Sticker r0 = this.a;
        if (r0 == null) goto L7;
        List r1 = r0.getComposerConfigList();
        if (r1 == null) goto L7;
        return r1.size();
    L7:
        return 0;
    }

    public AdjustBarListAdapter(d r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "onLevelChangeListener");
        this.c = r2;
        this.d = r3;
        this.b = new LinkedHashMap();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        AdjustBarViewHolder r7 = (AdjustBarViewHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        BeautifyAdjustPercentBar r8 = (BeautifyAdjustPercentBar) ((RecyclerView.ViewHolder) r7).itemView.findViewById(2131375706);
        if (r8 == null) goto L21;
        Sticker r0 = this.a;
        if (r0 == null) goto L22;
        List r1 = r0.getComposerConfigList();
        if (r1 == null) goto L23;
        Sticker.ComposerConfig r9 = (Sticker.ComposerConfig) ListProtector.get(r1, r7.getAdapterPosition());
        if (r9 == null) goto L24;
        d r2 = this.c;
        r8.U5(r2.a, r2.b, r2.c);
        r8.V5(this.c.d, r9.getName());
        r8.setEnableSingeAdjust(this.c.e);
        if (r9.getDoubleDirection() == false) goto L14;
        r8.Y5(50, -50, r9.getDefaultValue(), false);
    L15:
        Map<String, Integer> r3 = this.b;
        LinkedHashMap r4 = (LinkedHashMap) r3;
        Integer r11 = (Integer) r4.get(r9.getTag());
        if (r11 == null) goto L18;
        int r12 = r11.intValue();
    L19:
        r8.setPercent(r12);
        r8.setOnLevelChangeListener(new c(r9, this));
        return;
    L18:
        r12 = r9.getDefaultValue();
        goto L19
    L14:
        r8.Y5(100, 0, r9.getDefaultValue(), true);
        goto L15
    L24:
        return;
    L23:
        return;
    L22:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new AdjustBarViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131565835, r4, false));
    }
}
