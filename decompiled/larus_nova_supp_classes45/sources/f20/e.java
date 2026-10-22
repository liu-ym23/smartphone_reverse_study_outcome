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
public final class e extends g<f10.f, OpenFeatureTabListItemViewHolder> {
    public final a20.e a;

    @Override // f20.c
    public final boolean accept(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return true;
    }

    public e(a20.e r1) {
        this.a = r1;
    }

    @Override // f20.a
    public final RecyclerView.ViewHolder a(LayoutInflater r6, ViewGroup r7) {
        Intrinsics.checkNotNullParameter(r6, "inflater");
        Intrinsics.checkNotNullParameter(r7, "parent");
        Room r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L8;
        m r1 = r0.getRoom();
        if (r1 == null) goto L8;
        r4 = (Room) r1.getValue();
    L8:
        if (r4 == null) goto L10;
        View r8 = r6.inflate(2131567066, r7, false);
    L12:
        return new OpenFeatureTabListItemViewHolder(r8, this.a);
    L10:
        r8 = r6.inflate(2131567067, r7, false);
        goto L12
    }
}
