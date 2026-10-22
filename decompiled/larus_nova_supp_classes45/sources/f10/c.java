package f10;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.api.toolbar.InteractGroupNameViewHolder;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveOpenFeatureChooseConfig;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c extends me.drakeet.multitype.b<b, InteractGroupNameViewHolder> {
    public c() {
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        InteractGroupNameViewHolder r4 = (InteractGroupNameViewHolder) r2;
        b r5 = (b) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "item");
        if (TextUtils.isEmpty(r5.a) == false) goto L5;
        r4.a.setVisibility(8);
        return;
    L5:
        r4.a.setText(r5.a);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r6, ViewGroup r7) {
        Intrinsics.checkNotNullParameter(r6, "inflater");
        Intrinsics.checkNotNullParameter(r7, "parent");
        String r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L10;
        m r1 = r0.getRoom();
        if (r1 == null) goto L10;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L10;
        r4 = r2.getIdStr();
    L10:
        if (r4 != null) goto L13;
        View r8 = r6.inflate(2131566199, r7, false);
    L17:
        return new InteractGroupNameViewHolder(r8);
    L13:
        if (LiveOpenFeatureChooseConfig.useV3() == false) goto L15;
        r8 = r6.inflate(2131566200, r7, false);
        goto L17
    L15:
        r8 = r6.inflate(2131566198, r7, false);
        goto L17
    }
}
