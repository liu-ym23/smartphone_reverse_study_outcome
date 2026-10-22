package f20;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.OpenFeatureInteractTabItemViewHolder;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d extends g<f10.f, OpenFeatureInteractTabItemViewHolder> {
    public final a20.e a;
    public final boolean b;

    public d(a20.e r1) {
        this.a = r1;
        this.b = true;
    }

    @Override // f20.c
    public final boolean accept(Object r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        if ((r3 instanceof f10.f) == false) goto L11;
        f10.f r4 = (f10.f) r3;
        if (((ExtendedToolbarButton.c) r4).k != InteractID.InteractLoki.getValue()) goto L7;
    L10:
        return true;
    L7:
        if (((ExtendedToolbarButton.c) r4).k == InteractID.InteractGamePlus.getValue()) goto L10;
        if (((ExtendedToolbarButton.c) r4).k == InteractID.InteractMiniApp.getValue()) goto L10;
    L11:
        return false;
    }

    @Override // f20.a
    public final RecyclerView.ViewHolder a(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new OpenFeatureInteractTabItemViewHolder(r4.inflate(2131567074, r5, false), this.a, this.b);
    }
}
