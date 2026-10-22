package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter;

import a20.d;
import a20.e;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.OpenFeatureGroupListItemViewHolder;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import f10.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends me.drakeet.multitype.b<f, OpenFeatureGroupListItemViewHolder> {
    public final e b;

    public a(d r1) {
        this.b = r1;
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        OpenFeatureGroupListItemViewHolder r4 = (OpenFeatureGroupListItemViewHolder) r2;
        f r5 = (f) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        r4.T3(r5);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r6, ViewGroup r7) {
        Intrinsics.checkNotNullParameter(r6, "inflater");
        Intrinsics.checkNotNullParameter(r7, "parent");
        Room r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L8;
        m r1 = r0.getRoom();
        if (r1 == null) goto L8;
        r4 = (Room) r1.getValue();
    L8:
        if (r4 != null) goto L10;
        View r8 = r6.inflate(2131567078, r7, false);
    L12:
        return new OpenFeatureGroupListItemViewHolder(r8, this.b);
    L10:
        r8 = r6.inflate(2131567077, r7, false);
        goto L12
    }
}
