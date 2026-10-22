package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.OpenFeatureRecentUsedGroupListAdapter;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/OpenFeatureRecentUsedListRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenFeatureRecentUsedListRecyclerView extends RecyclerView {
    public final OpenFeatureRecentUsedGroupListAdapter a;

    /* JADX WARN: Multi-variable type inference failed */
    public OpenFeatureRecentUsedListRecyclerView(Context r5, OpenFeatureRecentUsedGroupListAdapter r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "recentUsedAdapter");
        super(r5);
        this.a = r6;
        LinearLayoutManager r0 = new LinearLayoutManager(r5);
        final boolean r7 = false;
        r0.setOrientation(0);
        Unit r1 = Unit.INSTANCE;
        setLayoutManager(r0);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setAdapter(r6);
        setOverScrollMode(2);
        Room r3 = null;
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r8 == null) goto L7;
        m r9 = r8.getRoom();
        if (r9 == null) goto L7;
        r3 = (Room) r9.getValue();
    L7:
        if (r3 == null) goto L9;
        r7 = true;
    L9:
        addItemDecoration(new AnonymousClass2(r7));
    }
}
