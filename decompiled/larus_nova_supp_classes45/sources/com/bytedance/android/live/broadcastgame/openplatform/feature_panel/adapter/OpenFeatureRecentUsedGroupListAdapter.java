package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter;

import a20.e;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.OpenFeatureGroupListItemViewHolder;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import f10.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/adapter/OpenFeatureRecentUsedGroupListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/OpenFeatureGroupListItemViewHolder;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenFeatureRecentUsedGroupListAdapter extends RecyclerView.Adapter<OpenFeatureGroupListItemViewHolder> {
    public List<f> a;
    public final e b;

    public final int getItemCount() {
        return this.a.size();
    }

    public OpenFeatureRecentUsedGroupListAdapter(List<f> r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "itemList");
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        OpenFeatureGroupListItemViewHolder r4 = (OpenFeatureGroupListItemViewHolder) r2;
        Intrinsics.checkNotNullParameter(r4, "holder");
        r4.T3((f) ListProtector.get(this.a, r3));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        Room r3 = null;
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r7 == null) goto L8;
        m r8 = r7.getRoom();
        if (r8 == null) goto L8;
        r3 = (Room) r8.getValue();
    L8:
        if (r3 != null) goto L10;
        View r9 = LayoutInflater.from(r5.getContext()).inflate(2131567078, r5, false);
    L12:
        return new OpenFeatureGroupListItemViewHolder(r9, this.b);
    L10:
        r9 = LayoutInflater.from(r5.getContext()).inflate(2131567077, r5, false);
        goto L12
    }
}
