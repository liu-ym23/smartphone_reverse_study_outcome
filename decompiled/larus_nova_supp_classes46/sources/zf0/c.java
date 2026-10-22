package zf0;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.linkpanel.viewholder.EmptyInviteAudienceViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends me.drakeet.multitype.b<a, EmptyInviteAudienceViewHolder> {

    public static final class a {
        public a() {
        }
    }

    public c() {
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        Intrinsics.checkNotNullParameter((EmptyInviteAudienceViewHolder) r2, "p0");
        Intrinsics.checkNotNullParameter((a) r3, "p1");
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new EmptyInviteAudienceViewHolder(r3.inflate(2131566280, r4, false));
    }
}
