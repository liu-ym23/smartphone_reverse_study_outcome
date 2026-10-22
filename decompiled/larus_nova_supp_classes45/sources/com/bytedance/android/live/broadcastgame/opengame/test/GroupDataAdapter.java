package com.bytedance.android.live.broadcastgame.opengame.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/test/GroupDataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/broadcastgame/opengame/test/GroupDataViewHolder;", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupDataAdapter extends RecyclerView.Adapter<GroupDataViewHolder> {
    public final List<com.bytedance.android.live.broadcastgame.opengame.test.a> a;
    public final Context b;

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public GroupDataAdapter(List<com.bytedance.android.live.broadcastgame.opengame.test.a> r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "items");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        GroupDataViewHolder r7 = (GroupDataViewHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        r7.b.removeAllViews();
        UtilityKotlinExtentionsKt.z(r7.a, false);
        Iterator<String> r8 = ((com.bytedance.android.live.broadcastgame.opengame.test.a) ListProtector.get(this.a, r6)).b.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        String r0 = r8.next();
        TextView r1 = new TextView(this.b);
        r1.setTextColor(ColorProtector.parseColor("#FFFFFF"));
        r1.setAlpha(0.8f);
        r1.setTextSize(1, 12.0f);
        r1.setText(r0);
        r7.b.addView(r1);
        goto L4
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        return new GroupDataViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131567100, r3, false));
    }
}
