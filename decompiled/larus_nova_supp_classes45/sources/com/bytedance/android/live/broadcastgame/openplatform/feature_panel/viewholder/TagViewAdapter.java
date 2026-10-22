package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.api.model.v;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/TagViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/TagViewAdapter$TagViewHolder;", "TagViewHolder", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TagViewAdapter extends RecyclerView.Adapter<TagViewHolder> {
    public final List<v> a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/TagViewAdapter$TagViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TagViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;

        public TagViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = (TextView) r2.findViewById(2131388148);
        }
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public TagViewAdapter(List<v> r2) {
        Intrinsics.checkNotNullParameter(r2, "dataList");
        this.a = r2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        TagViewHolder r4 = (TagViewHolder) r2;
        Intrinsics.checkNotNullParameter(r4, "holder");
        v r5 = (v) ListProtector.get(this.a, r3);
        if (r5.text.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        UtilityKotlinExtentionsKt.t(r4.a);
    L9:
        r4.a.setText(r5.text);
        return;
    L8:
        UtilityKotlinExtentionsKt.w(r4.a);
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new TagViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131567075, r3, false));
    }
}
