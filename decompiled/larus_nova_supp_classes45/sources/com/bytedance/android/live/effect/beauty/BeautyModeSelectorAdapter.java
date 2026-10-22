package com.bytedance.android.live.effect.beauty;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/BeautyModeSelectorAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/beauty/BeautyModeSelectorAdapter$BeautyModeItemView;", "<init>", "()V", "BeautyModeItemView", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BeautyModeSelectorAdapter extends RecyclerView.Adapter<BeautyModeItemView> {
    public final List<Pair<String, String>> a;
    public String b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/BeautyModeSelectorAdapter$BeautyModeItemView;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class BeautyModeItemView extends RecyclerView.ViewHolder {
        public final TextView a;
        public final ImageView b;

        public BeautyModeItemView(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (TextView) r2.findViewById(2131390961);
            this.b = (ImageView) r2.findViewById(2131376591);
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public BeautyModeSelectorAdapter() {
        this.a = new ArrayList();
        this.b = "normal";
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        BeautyModeItemView r6 = (BeautyModeItemView) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        String r0 = (String) ((Pair) ListProtector.get(this.a, r5)).getFirst();
        String r7 = (String) ((Pair) ListProtector.get(this.a, r5)).getSecond();
        r6.a.setText(r7);
        ImageView r1 = r6.b;
        if (Intrinsics.areEqual(this.b, r0) == false) goto L5;
        int r2 = 0;
    L6:
        r1.setVisibility(r2);
        ((RecyclerView.ViewHolder) r6).itemView.setOnClickListener(new b(this, r0, r7, r6));
        return;
    L5:
        r2 = 4;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new BeautyModeItemView(LayoutInflater.from(r4.getContext()).inflate(2131565845, r4, false));
    }
}
