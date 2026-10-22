package xp0;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.CoexistAnchorShelfDisplayDialog;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.banner.AnchorShelfDisplayBannerItemViewHolder;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends me.drakeet.multitype.b<d, AnchorShelfDisplayBannerItemViewHolder> {
    public final a b;

    public b(CoexistAnchorShelfDisplayDialog.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.b = r2;
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        AnchorShelfDisplayBannerItemViewHolder r4 = (AnchorShelfDisplayBannerItemViewHolder) r2;
        d r5 = (d) r3;
        Intrinsics.checkNotNullParameter(r4, "vh");
        Intrinsics.checkNotNullParameter(r5, "data");
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "data");
        String r6 = i2.a;
        i2.h(r4.b, "/openplatform/ttlive_mini_app_shelf_page_anchor_banner.png");
        r4.c.setOnClickListener(new c(r4));
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new AnchorShelfDisplayBannerItemViewHolder(r3.inflate(2131566967, r4, false), this.b);
    }
}
