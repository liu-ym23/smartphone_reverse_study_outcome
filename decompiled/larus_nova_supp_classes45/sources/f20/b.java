package f20;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.OpenFeatureTabListItemViewHolder;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends g<f10.f, OpenFeatureTabListItemViewHolder> {
    @Override // f20.c
    public final boolean accept(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return false;
    }

    public b() {
    }

    @Override // f20.a
    public final RecyclerView.ViewHolder a(LayoutInflater r6, ViewGroup r7) {
        Intrinsics.checkNotNullParameter(r6, "inflater");
        Intrinsics.checkNotNullParameter(r7, "parent");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        Room r2 = (Room) r1.getValue();
    L9:
        if (r2 == null) goto L11;
        View r8 = r6.inflate(2131567066, r7, false);
    L13:
        return new OpenFeatureTabListItemViewHolder(r8, null);
    L11:
        r8 = r6.inflate(2131567067, r7, false);
    L7:
        r2 = null;
        goto L9
    }
}
