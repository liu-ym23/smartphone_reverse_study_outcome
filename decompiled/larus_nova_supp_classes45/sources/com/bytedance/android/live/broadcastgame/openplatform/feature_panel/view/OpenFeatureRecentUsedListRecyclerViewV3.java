package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.v3.OpenFeatureRecentUsedGroupListAdapterV3;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/OpenFeatureRecentUsedListRecyclerViewV3;", "Landroidx/recyclerview/widget/RecyclerView;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenFeatureRecentUsedListRecyclerViewV3 extends RecyclerView {
    public final OpenFeatureRecentUsedGroupListAdapterV3 a;

    /* JADX WARN: Multi-variable type inference failed */
    public OpenFeatureRecentUsedListRecyclerViewV3(Context r4, OpenFeatureRecentUsedGroupListAdapterV3 r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "recentUsedAdapter");
        super(r4);
        this.a = r5;
        LinearLayoutManager r0 = new LinearLayoutManager(r4);
        r0.setOrientation(0);
        Unit r6 = Unit.INSTANCE;
        setLayoutManager(r0);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setAdapter(r5);
        setOverScrollMode(2);
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r7 == null) goto L7;
        m r8 = r7.getRoom();
        if (r8 == null) goto L7;
        Room r9 = (Room) r8.getValue();
    L7:
        addItemDecoration(new AnonymousClass2());
    }
}
