package com.bytedance.android.live.broadcastgame.xplay.perf;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/perf/GroupDataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/broadcastgame/xplay/perf/GroupDataViewHolder;", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupDataAdapter extends RecyclerView.Adapter<GroupDataViewHolder> {
    public final List<String> a;
    public final Context b;

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public GroupDataAdapter(List<String> r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "items");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        GroupDataViewHolder r5 = (GroupDataViewHolder) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        String r6 = (String) ListProtector.get(this.a, r4);
        TextView r7 = r5.a;
        r7.setTextColor(ColorProtector.parseColor("#FFFFFF"));
        r7.setAlpha(0.8f);
        r7.setTextSize(1, 12.0f);
        r7.setText(r6);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        return new GroupDataViewHolder(new TextView(this.b));
    }
}
